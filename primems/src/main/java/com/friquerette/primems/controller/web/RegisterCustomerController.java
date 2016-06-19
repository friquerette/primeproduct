package com.friquerette.primems.controller.web;

import static com.friquerette.primems.controller.web.AbstractWebController.ROOT_REGISTER;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.friquerette.primems.core.entity.Customer;
import com.friquerette.primems.core.service.CustomerService;
import com.friquerette.primems.core.service.PrimemsServiceException;

/**
 * The registration service of the application
 * 
 * @author Rick
 *
 */
@Controller
@RequestMapping(ROOT_REGISTER)
public class RegisterCustomerController {
	private static final Logger logger = LoggerFactory.getLogger(RegisterCustomerController.class);

	@Autowired(required = true)
	@Qualifier(value = "customerService")
	private CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("customer", customerService.getNewCustomer());

		// List<String> professionList = new ArrayList<>();
		// professionList.add("Developer");
		// professionList.add("Designer");
		// professionList.add("IT Manager");
		// model.addAttribute("professionList", professionList);
		return "register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("customer") Customer customer, Map<String, Object> model) {

		// implement your own registration logic here...

		// for testing purpose:
		logger.info("read UserName: " + customer.getUserName());
		System.out.println("birth date: " + customer.getBirthdate());
		// System.out.println("profession: " + customer.getProfession());
		try {
			customerService.createCustomer(customer);
			logger.info("user create with ID " + customer.getId());
			return "registrationsuccess";
		} catch (PrimemsServiceException e) {
			logger.error("Failed to create the user", e);
			return "registrationfailed";
		}
	}
}
