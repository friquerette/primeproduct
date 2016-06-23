package com.friquerette.primejs.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.friquerette.primejs.controller.web.converterweb.ProductConverter;
import com.friquerette.primejs.core.entity.Product;
import com.friquerette.primejs.core.service.CustomerService;
import com.friquerette.primejs.core.service.ProductService;

/**
 * The welcome page of the application
 * 
 * @author Rick
 *
 */
@Controller
@RequestMapping("/")
public class WelcomeController extends AbstractWebController {
	@Autowired(required = true)
	private CustomerService customerService;

	@Autowired(required = true)
	private ProductService productService;

	@Autowired(required = true)
	private ProductConverter productConverter;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setProductConverter(ProductConverter productConverter) {
		this.productConverter = productConverter;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView welcome(Model model) {
		ModelAndView modelView = new ModelAndView("home");
		try {
			model.addAttribute("products", this.productService.findAll());
		} catch (Exception e) {
			modelView = new ModelAndView("error");
			modelView.addObject("message", "Failed to read the product list");
			modelView.addObject("cause", e.getCause());
		}
		return modelView;
	}

	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public ModelAndView view(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView("view");
		try {
			Product product = productService.findById(id);
			model.addObject("product", productConverter.toWeb(product));
			return model;
		} catch (Exception e) {
			model = new ModelAndView("error");
			model.addObject("message", "Failed to read the product id " + id);
			model.addObject("cause", e.getCause());
			return model;
		}
	}

	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", customerService.getAuthenticationUsername());
		return "accessdenied";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:./";
	}

}
