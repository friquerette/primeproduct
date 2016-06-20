package com.friquerette.primems.controller.web;

import static com.friquerette.primems.controller.web.AbstractWebController.ADMIN_PRODUCTS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.friquerette.primems.core.entity.Customer;
import com.friquerette.primems.core.service.ProductService;

@Controller
@RequestMapping(ADMIN_PRODUCTS)
public class AdminProductController extends AbstractWebController {

	@Autowired(required = true)
	@Qualifier(value = "productService")
	private ProductService productService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String admin(Model model) {
		model.addAttribute("product", new Customer());
		model.addAttribute("products", this.productService.findAll());
		return "admin/products";
	}
}
