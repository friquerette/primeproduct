package com.friquerette.primejs.controller.web;

import static com.friquerette.primejs.controller.web.AbstractWebController.ACCOUNT_HOME;

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

import com.friquerette.primejs.controller.web.converterweb.ProductConverter;
import com.friquerette.primejs.controller.web.webmodel.ProductWeb;
import com.friquerette.primejs.core.boundary.entity.CurrencyEnum;
import com.friquerette.primejs.core.boundary.service.FixerService;
import com.friquerette.primejs.core.entity.Category;
import com.friquerette.primejs.core.entity.GenderEnum;
import com.friquerette.primejs.core.entity.Product;
import com.friquerette.primejs.core.service.ProductService;

/**
 * To reach this part of the application the user have to be authenticated
 * 
 * @author Rick
 *
 */
@Controller
@RequestMapping(ACCOUNT_HOME)
public class ProductController extends AbstractWebController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

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

	/**
	 * Should be in a service list
	 * 
	 * @return
	 */

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String listCustomers(Model model) {
		model.addAttribute("products", this.productService.findForCurrentUser());
		return "account/products";
	}

	// -- UPDATE
	@RequestMapping(value = PATH_EDIT_ID, method = RequestMethod.GET)
	public ModelAndView updateForm(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView("account/product");
		Product product = productService.findById(id);
		model.addObject("product", productConverter.toWeb(product));
		model.addObject("genderList", GenderEnum.values());
		return model;
	}

	@RequestMapping(value = PATH_EDIT_ID, method = RequestMethod.POST)
	public String update(@ModelAttribute("product") ProductWeb web, Map<String, Object> map) {
		productService.update(productConverter.fromWeb(web));
		return "redirect:../products";
	}

	// -- CREATE
	@RequestMapping(value = PATH_NEW, method = RequestMethod.GET)
	public ModelAndView newForm() {
		ModelAndView model = new ModelAndView("admin/product");
		model.addObject("product", productConverter.toWeb(null));
		List<Category> category = getCategoryService().getAllActiveCategoryForSelect();
		model.addObject("categoriesList", entityToSelect(category));
		model.addObject("currenciesList", getCurrenciesList());
		return model;
	}

	@RequestMapping(value = PATH_NEW, method = RequestMethod.POST)
	public String create(@ModelAttribute("product") ProductWeb web, Map<String, Object> map) {
		productService.create(productConverter.fromWeb(web));
		return "redirect:../products";
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
