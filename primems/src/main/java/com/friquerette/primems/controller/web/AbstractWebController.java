package com.friquerette.primems.controller.web;

/**
 * 
 * Some common constant to the controller and maybe useful method
 * 
 * @author Rick
 *
 */
public class AbstractWebController {
	protected final static String ROOT_HOME = "/home";
	protected final static String ACCOUNT_HOME = ROOT_HOME + "/account";
	protected final static String ADMIN_CUSTOMERS = ROOT_HOME + "/admin/customers";
	protected final static String ADMIN_PRODUCTS = ROOT_HOME + "/admin/products";
	protected final static String ADMIN_CATEGORIES = ROOT_HOME + "/admin/categories";
	protected final static String ROOT_REGISTER = "/register";

	protected final static String PATH_ALL = "/all";
	protected final static String PATH_EDIT = "/edit/{id}";
	protected final static String PATH_DELETE = "/delete/{id}";
	protected final static String PATH_NEW = "/edit/new";

}
