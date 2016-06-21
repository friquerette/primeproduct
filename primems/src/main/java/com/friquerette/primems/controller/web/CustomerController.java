package com.friquerette.primems.controller.web;

import static com.friquerette.primems.controller.web.AbstractWebController.ACCOUNT_CUSTOMER;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.friquerette.primems.controller.web.converterweb.CustomerConverter;
import com.friquerette.primems.controller.web.webmodel.CustomerWeb;
import com.friquerette.primems.core.entity.Customer;
import com.friquerette.primems.core.entity.GenderEnum;
import com.friquerette.primems.core.service.CustomerService;

/**
 * To reach this part of the application the user have to be authenticated
 * 
 * @author Rick
 *
 */
@Controller
@RequestMapping(ACCOUNT_CUSTOMER)
public class CustomerController extends AbstractWebController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired(required = true)
	private CustomerService customerService;

	@Autowired(required = true)
	private CustomerConverter customerConverter;

	@RequestMapping(value = PATH_EDIT, method = RequestMethod.GET)
	public ModelAndView edit(Model model) {
		ModelAndView modelView = new ModelAndView("account/customer");
		model.addAttribute("customer", this.customerService.getCurrentCustomerFromContext());
		Customer customer = this.customerService.getCurrentCustomerFromContext();
		modelView.addObject("customer", customerConverter.toWeb(customer));
		modelView.addObject("genderMap", GenderEnum.getAllAsMap());
		return modelView;
	}

	@RequestMapping(value = PATH_EDIT, method = RequestMethod.POST)
	public String update(@ModelAttribute("customer") CustomerWeb web, Map<String, Object> map) {
		try {
			customerService.update(customerConverter.fromWeb(web));
		} catch (Exception e) {
			logger.error("failed to update the user", e);
		}

		return "redirect:./edit";
	}

}
