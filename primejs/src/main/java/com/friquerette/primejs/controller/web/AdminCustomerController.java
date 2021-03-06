package com.friquerette.primejs.controller.web;

import static com.friquerette.primejs.controller.web.AbstractWebController.ADMIN_CUSTOMERS;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.friquerette.primejs.controller.web.converterweb.CustomerConverter;
import com.friquerette.primejs.controller.web.webmodel.CustomerWeb;
import com.friquerette.primejs.core.entity.Customer;
import com.friquerette.primejs.core.entity.GenderEnum;
import com.friquerette.primejs.core.entity.RoleEnum;
import com.friquerette.primejs.core.service.CustomerService;

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
	@RequestMapping(value = PATH_EDIT_ID, method = RequestMethod.GET)
	public ModelAndView updateForm(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView("admin/customer");
		Customer customer = customerService.findById(id);
		model.addObject("customer", customerConverter.toWeb(customer));
		model.addObject("genderMap", GenderEnum.getAllAsMap());
		model.addObject("roleMap", RoleEnum.getAllAsMap());
		return model;
	}

	@RequestMapping(value = PATH_EDIT_ID, method = RequestMethod.POST)
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

}
