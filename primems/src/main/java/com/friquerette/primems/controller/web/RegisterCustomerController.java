package com.friquerette.primems.controller.web;

import static com.friquerette.primems.controller.web.AbstractWebController.ROOT_REGISTER;

import java.util.List;
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
import org.springframework.web.servlet.ModelAndView;

import com.friquerette.primems.core.entity.Customer;
import com.friquerette.primems.core.entity.GenderEnum;
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

	@ModelAttribute("genderList")
	public List<GenderEnum> getAllSupportedLanguages() {
		return GenderEnum.getAllGenders();
	}

	@Autowired(required = true)
	@Qualifier(value = "customerService")
	private CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("customer", customerService.getInstance());

		model.addAttribute("genderList", GenderEnum.values());

		return "register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processRegistration(@ModelAttribute("customer") Customer customer, Map<String, Object> model) {
		logger.info("read UserName: " + customer.getUserName());
		System.out.println("birth date: " + customer.getBirthdate());
		try {
			customerService.create(customer);
			logger.info("user create with ID " + customer.getId());
			return new ModelAndView("registrationsuccess", "customer", customer);
		} catch (PrimemsServiceException e) {
			logger.error("Failed to create the user", e);
			ModelAndView modelError = new ModelAndView("registrationfailed");
			modelError.addObject("message", e.getErrMsg());
			modelError.addObject("cause", e.getCauseMsg());
			return modelError;
		}
	}
}
