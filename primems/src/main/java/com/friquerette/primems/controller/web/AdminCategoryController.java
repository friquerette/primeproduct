package com.friquerette.primems.controller.web;

import static com.friquerette.primems.controller.web.AbstractWebController.ADMIN_CATEGORIES;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	public void setCustomerService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String admin(Model model) {
		model.addAttribute("category", new Customer());
		model.addAttribute("categorys", this.categoryService.findAllCategories());
		return "admin/categories";
	}
}
