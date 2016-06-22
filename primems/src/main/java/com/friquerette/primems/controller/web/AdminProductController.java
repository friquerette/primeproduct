package com.friquerette.primems.controller.web;

import static com.friquerette.primems.controller.web.AbstractWebController.ADMIN_PRODUCTS;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.friquerette.primems.controller.web.converterweb.ProductConverter;
import com.friquerette.primems.controller.web.webmodel.ProductWeb;
import com.friquerette.primems.core.boundary.entity.CurrencyEnum;
import com.friquerette.primems.core.boundary.service.FixerService;
import com.friquerette.primems.core.entity.Category;
import com.friquerette.primems.core.entity.Product;
import com.friquerette.primems.core.service.ProductService;

@Controller
@RequestMapping(ADMIN_PRODUCTS)
public class AdminProductController extends AbstractWebController {

	private static final Logger logger = LoggerFactory.getLogger(AdminProductController.class);

	@Autowired(required = true)
	private ProductService productService;

	@Autowired(required = true)
	private ProductConverter productConverter;

	@Autowired(required = true)
	private FixerService fixerService;

	public FixerService getFixerService() {
		return fixerService;
	}

	public void setFixerService(FixerService fixerService) {
		this.fixerService = fixerService;
	}

	@RequestMapping(value = PATH_ALL, method = RequestMethod.GET)
	public String admin(Model model) {
		model.addAttribute("products", this.productService.findAll());
		return "admin/products";
	}

	// -- DELETE
	@RequestMapping(value = PATH_DELETE)
	public String delete(@PathVariable("id") long id) {
		productService.deleteById(id);
		return "redirect:.." + PATH_ALL;
	}

	// -- UPDATE
	@RequestMapping(value = PATH_EDIT_ID, method = RequestMethod.GET)
	public ModelAndView updateForm(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView("admin/product");
		Product product = productService.findById(id);
		model.addObject("product", productConverter.toWeb(product));
		model.addObject("categoriesList", getCategoriesList());
		return model;
	}

	@RequestMapping(value = PATH_EDIT_ID, method = RequestMethod.POST)
	public String update(@ModelAttribute("product") ProductWeb web, Map<String, Object> map) {
		productService.update(productConverter.fromWeb(web));
		return "redirect:.." + PATH_ALL;
	}

	// -- CREATE
	@RequestMapping(value = PATH_NEW, method = RequestMethod.GET)
	public ModelAndView newForm() {
		ModelAndView model = new ModelAndView("admin/product");
		model.addObject("product", productConverter.toWeb(null));
		model.addObject("categoriesList", getCategoriesList());
		model.addObject("currenciesList", getCurrenciesList());
		return model;
	}

	@RequestMapping(value = PATH_NEW, method = RequestMethod.POST)
	public String create(@ModelAttribute("product") ProductWeb web, Map<String, Object> map) {
		productService.create(productConverter.fromWeb(web));
		return "redirect:.." + PATH_ALL;
	}

	protected Map<Long, String> getCategoriesList() {
		Map<Long, String> categoriesMap = null;
		try {
			List<Category> category = getCategoryService().getAllActiveCategoryForSelect();
			categoriesMap = entityToSelect(category);
		} catch (Exception e) {
			logger.error("Failed to load the categories for list select", e);
		}
		return categoriesMap;
	}

	/**
	 * Should be in a service list
	 * 
	 * @return
	 */
	protected Map<String, String> getCurrenciesList() {
		Map<String, String> currenciesMap = null;
		try {
			List<CurrencyEnum> category = getFixerService().getAllCurrencies();
			currenciesMap = enumToSelect(category);
		} catch (Exception e) {
			logger.error("Failed to load the categories for list select", e);
		}
		return currenciesMap;
	}
}
