package com.friquerette.primems.controller.web;

import static com.friquerette.primems.controller.web.AbstractWebController.ADMIN_CUSTOMERS;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.friquerette.primems.controller.web.converterenum.GenderEnumConverter;
import com.friquerette.primems.controller.web.converterenum.RoleEnumConverter;
import com.friquerette.primems.controller.web.converterweb.CustomerConverter;
import com.friquerette.primems.controller.web.webmodel.CustomerWeb;
import com.friquerette.primems.core.entity.Customer;
import com.friquerette.primems.core.entity.GenderEnum;
import com.friquerette.primems.core.entity.RoleEnum;
import com.friquerette.primems.core.service.CustomerService;

/**
 * To access to this part of the application the user have to be an
 * administrator
 * 
 * @author Rick
 *
 */
@Controller
@RequestMapping(ADMIN_CUSTOMERS)
public class AdminCustomerController extends AbstractWebController {
	@Autowired(required = true)
	private CustomerService customerService;

	@Autowired(required = true)
	private CustomerConverter customerConverter;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	// ALL
	@RequestMapping(value = PATH_ALL, method = RequestMethod.GET)
	public String admin(Model model) {
		model.addAttribute("customers", this.customerService.findAll());
		return "admin/customers";
	}

	// -- DELETE
	@RequestMapping(value = PATH_DELETE)
	public String delete(@PathVariable("id") long id) {
		customerService.deleteById(id);
		return "redirect:.." + PATH_ALL;
	}

	// -- UPDATE
	@RequestMapping(value = PATH_EDIT, method = RequestMethod.GET)
	public ModelAndView updateForm(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView("admin/customer");
		Customer customer = customerService.findById(id);
		model.addObject("customer", customerConverter.toWeb(customer));
		model.addObject("genderList", GenderEnum.values());
		return model;
	}

	@RequestMapping(value = PATH_EDIT, method = RequestMethod.POST)
	public String update(@ModelAttribute("customer") CustomerWeb web, Map<String, Object> map) {
		customerService.update(customerConverter.fromWeb(web));
		return "redirect:.." + PATH_ALL;
	}

	// -- CREATE
	@RequestMapping(value = PATH_NEW, method = RequestMethod.GET)
	public ModelAndView newForm() {
		ModelAndView model = new ModelAndView("admin/customer");
		model.addObject("customer", customerConverter.toWeb(null));
		return model;
	}

	@RequestMapping(value = PATH_NEW, method = RequestMethod.POST)
	public String create(@ModelAttribute("customer") CustomerWeb web, Map<String, Object> map) {
		customerService.create(customerConverter.fromWeb(web));
		return "redirect:.." + PATH_ALL;
	}

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.registerCustomEditor(GenderEnum.class, new GenderEnumConverter());
		dataBinder.registerCustomEditor(RoleEnum.class, new RoleEnumConverter());
	}
}
