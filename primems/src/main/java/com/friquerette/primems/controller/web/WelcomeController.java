package com.friquerette.primems.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.friquerette.primems.core.service.CustomerService;
import com.friquerette.primems.core.service.ProductService;

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

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("products", this.productService.findAll());
		return "home";
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
		return "index";
	}

}
