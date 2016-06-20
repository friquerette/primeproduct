package com.friquerette.primems.controller.web;

import static com.friquerette.primems.controller.web.AbstractWebController.ADMIN_CATEGORIES;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.friquerette.primems.controller.web.converterweb.CategoryConverter;
import com.friquerette.primems.controller.web.webmodel.CategoryWeb;
import com.friquerette.primems.core.entity.Category;
import com.friquerette.primems.core.entity.Customer;
import com.friquerette.primems.core.service.CategoryService;

/**
 * To reach this part of the application the user have to be an admin
 * 
 * @author Rick
 *
 */
@Controller
@RequestMapping(ADMIN_CATEGORIES)
public class AdminCategoryController extends AbstractWebController {
	@Autowired(required = true)
	@Qualifier(value = "categoryService")
	private CategoryService categoryService;

	@Autowired(required = true)
	@Qualifier(value = "categoryConverter")
	private CategoryConverter categoryConverter;

	@RequestMapping(value = PATH_ALL, method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("category", new Customer());
		model.addAttribute("categories", this.categoryService.findAllCategories());
		return "admin/categories";
	}

	// -- DELETE
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable("id") long id) {
		categoryService.deleteCategoryById(id);
		return "redirect:.." + PATH_ALL;
	}

	// -- UPDATE
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView updateForm(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView("admin/category");
		Category category = categoryService.findById(id);
		model.addObject("category", categoryConverter.toWeb(category));
		return model;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute("category") CategoryWeb web, Map<String, Object> map) {
		categoryService.updateCategory(categoryConverter.fromWeb(web));
		return "redirect:.." + PATH_ALL;
	}

	// -- CREATE
	@RequestMapping(value = "/edit/new", method = RequestMethod.GET)
	public ModelAndView newForm() {
		ModelAndView model = new ModelAndView("admin/category");
		model.addObject("category", categoryConverter.toWeb(null));
		return model;
	}

	@RequestMapping(value = "/edit/new", method = RequestMethod.POST)
	public String create(@ModelAttribute("category") CategoryWeb web, Map<String, Object> map) {
		categoryService.createCategory(categoryConverter.fromWeb(web));
		return "redirect:.." + PATH_ALL;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setCategoryConverter(CategoryConverter categoryConverter) {
		this.categoryConverter = categoryConverter;
	}
}