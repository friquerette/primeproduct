package com.friquerette.primems.core.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.friquerette.primems.controller.web.converter.GenderEnumConverter;
import com.friquerette.primems.controller.web.converter.RoleEnumConverter;
import com.friquerette.primems.core.entity.Customer;
import com.friquerette.primems.core.entity.GenderEnum;
import com.friquerette.primems.core.entity.RoleEnum;

@Repository("customerDao")
public class CustomerDaoImpl extends AbstractDao<Customer>implements CustomerDao {

	@Override
	public Long create(Customer customer) {
		return persistEntity(customer);
	}

	@Override
	public void update(Customer customer) {
		updateEntity(customer);
	}

	@Override
	public Customer findById(Long id) {
		Criteria criteria = getSession().createCriteria(Customer.class);
		criteria.add(Restrictions.eq("id", id));
		return (Customer) criteria.uniqueResult();

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Customer> findAll() {
		Criteria criteria = getSession().createCriteria(Customer.class);
		return (List<Customer>) criteria.list();
	}

	@Override
	public void delete(Customer customer) {
		super.deleteEntity(customer);
	}

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.registerCustomEditor(GenderEnum.class, new GenderEnumConverter());
		dataBinder.registerCustomEditor(RoleEnum.class, new RoleEnumConverter());
	}
}
