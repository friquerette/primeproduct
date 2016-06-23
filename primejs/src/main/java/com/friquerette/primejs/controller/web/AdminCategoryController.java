package com.friquerette.primejs.controller.web;

import static com.friquerette.primejs.controller.web.AbstractWebController.ADMIN_CATEGORIES;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.friquerette.primejs.controller.web.converterweb.CategoryConverter;
import com.friquerette.primejs.controller.web.webmodel.CategoryWeb;
import com.friquerette.primejs.core.entity.Category;
import com.friquerette.primejs.core.entity.Customer;

/**
 * To reach this part of the application the user have to be an admin
 * 
 * @author Rick
 *
 */
@Controller
@RequestMapping(ADMIN_CATEGORIES)
public class AdminCategoryController extends AbstractWebController {

	private static final Logger logger = LoggerFactory.getLogger(AdminCategoryController.class);

	@Autowired(required = true)
	@Qualifier(value = "categoryConverter")
	private CategoryConverter categoryConverter;

	// ALL
	@RequestMapping(value = PATH_ALL, method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("category", new Customer());
		model.addAttribute("categories", getCategoryService().findAll());
		return "admin/categories";
	}

	// -- DELETE
	@RequestMapping(value = PATH_DELETE)
	public String delete(@PathVariable("id") long id) {
		try {
			getCategoryService().deleteById(id);
		} catch (Exception e) {
			logger.error("Failed to delete the category" + id, e);
		}

		return "redirect:.." + PATH_ALL;
	}

	// -- UPDATE
	@RequestMapping(value = PATH_EDIT_ID, method = RequestMethod.GET)
	public ModelAndView updateForm(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView("admin/category");
		Category category = getCategoryService().findById(id);
		model.addObject("category", categoryConverter.toWeb(category));
		model.addObject("categoriesList", getCategoriesList());
		return model;
	}

	@RequestMapping(value = PATH_EDIT_ID, method = RequestMethod.POST)
	public String update(@ModelAttribute("category") CategoryWeb web, Map<String, Object> map) {
		getCategoryService().update(categoryConverter.fromWeb(web));
		return "redirect:.." + PATH_ALL;
	}

	// -- CREATE
	@RequestMapping(value = PATH_NEW, method = RequestMethod.GET)
	public ModelAndView newForm() {
		ModelAndView model = new ModelAndView("admin/category");
		model.addObject("category", categoryConverter.toWeb(null));
		model.addObject("categoriesList", getCategoriesList());
		return model;
	}

	@RequestMapping(value = PATH_NEW, method = RequestMethod.POST)
	public String create(@ModelAttribute("category") CategoryWeb web, Map<String, Object> map) {
		getCategoryService().create(categoryConverter.fromWeb(web));
		return "redirect:.." + PATH_ALL;
	}

}