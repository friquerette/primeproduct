package com.friquerette.primems.controller.web;

import static com.friquerette.primems.controller.web.AbstractWebController.ACCOUNT_HOME;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.friquerette.primems.controller.web.converterenum.GenderEnumConverter;
import com.friquerette.primems.controller.web.converterenum.RoleEnumConverter;
import com.friquerette.primems.core.entity.Customer;
import com.friquerette.primems.core.entity.GenderEnum;
import com.friquerette.primems.core.entity.RoleEnum;
import com.friquerette.primems.core.service.CustomerService;

/**
 * To reach this part of the application the user have to be authenticated
 * 
 * @author Rick
 *
 */
@Controller
@RequestMapping(ACCOUNT_HOME)
public class CustomerController extends AbstractWebController {
	@Autowired(required = true)
	@Qualifier(value = "customerService")
	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public String listCustomers(Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("customers", this.customerService.findAll());
		return "account/customers";
	}

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.registerCustomEditor(GenderEnum.class, new GenderEnumConverter());
		dataBinder.registerCustomEditor(RoleEnum.class, new RoleEnumConverter());
	}

}
