package com.friquerette.primems.controller.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.friquerette.primems.controller.web.converterenum.GenderEnumConverter;
import com.friquerette.primems.controller.web.converterenum.RoleEnumConverter;
import com.friquerette.primems.core.entity.AbstractEntity;
import com.friquerette.primems.core.entity.GenderEnum;
import com.friquerette.primems.core.entity.RoleEnum;

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
	protected final static String ACCOUNT_CUSTOMER = ROOT_HOME + "/customer";
	protected final static String ADMIN_CUSTOMERS = ROOT_HOME + "/admin/customers";
	protected final static String ADMIN_PRODUCTS = ROOT_HOME + "/admin/products";
	protected final static String ADMIN_CATEGORIES = ROOT_HOME + "/admin/categories";
	protected final static String ROOT_REGISTER = "/register";

	protected final static String PATH_ALL = "/all";
	protected final static String PATH_EDIT_ID = "/edit/{id}";
	protected final static String PATH_EDIT = "/edit";
	protected final static String PATH_DELETE = "/delete/{id}";
	protected final static String PATH_NEW = "/edit/new";

	protected Map<Long, String> entityToSelect(List<? extends AbstractEntity> entity) {
		Map<Long, String> entitiesMap = new HashMap<>();
		if (entity != null) {
			for (AbstractEntity abstractEntity : entity) {
				entitiesMap.put(abstractEntity.getId(), abstractEntity.getLabel());
			}
		}
		return entitiesMap;
	}

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.registerCustomEditor(GenderEnum.class, new GenderEnumConverter());
		dataBinder.registerCustomEditor(RoleEnum.class, new RoleEnumConverter());
	}
}
