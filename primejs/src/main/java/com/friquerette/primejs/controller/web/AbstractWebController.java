package com.friquerette.primejs.controller.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.friquerette.primejs.controller.web.converterenum.GenderEnumConverter;
import com.friquerette.primejs.controller.web.converterenum.RoleEnumConverter;
import com.friquerette.primejs.core.entity.AbstractEntity;
import com.friquerette.primejs.core.entity.Category;
import com.friquerette.primejs.core.entity.GenderEnum;
import com.friquerette.primejs.core.entity.IPrimejsEnum;
import com.friquerette.primejs.core.entity.RoleEnum;
import com.friquerette.primejs.core.service.CategoryService;

/**
 * 
 * Some common constant to the controller and maybe useful method
 * 
 * @author Rick
 *
 */
public abstract class AbstractWebController {

	private static final Logger logger = LoggerFactory.getLogger(AbstractWebController.class);

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

	@Autowired(required = true)
	private CategoryService categoryService;

	protected Map<Long, String> entityToSelect(List<? extends AbstractEntity> entity) {
		Map<Long, String> entitiesMap = new HashMap<>();
		if (entity != null) {
			for (AbstractEntity abstractEntity : entity) {
				entitiesMap.put(abstractEntity.getId(), abstractEntity.getLabel());
			}
		}
		return entitiesMap;
	}

	protected Map<String, String> enumToSelect(List<? extends IPrimejsEnum> enums) {
		Map<String, String> entitiesMap = new HashMap<>();
		if (enums != null) {
			for (IPrimejsEnum anEnum : enums) {
				entitiesMap.put(anEnum.getValues(), anEnum.getLabel());
			}
		}
		return entitiesMap;
	}

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.registerCustomEditor(GenderEnum.class, new GenderEnumConverter());
		dataBinder.registerCustomEditor(RoleEnum.class, new RoleEnumConverter());
	}

	/**
	 * See later to generate a "service" to handle all the Select List
	 * 
	 * @return
	 */
	protected Map<Long, String> getCategoriesList() {
		Map<Long, String> categoriesMap = null;
		try {
			List<Category> category = getCategoryService().getAllActiveCategoryForSelect();
			categoriesMap = entityToSelect(category);
		} catch (Exception e) {
			logger.error("Failed to load the categories for list select", e);
		}
		return categoriesMap;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
}
