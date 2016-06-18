package com.friquerette.primems.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.friquerette.primems.entity.Customer;

@Repository("customerDao")
public class CustomerDaoImpl extends AbstractDao<Customer>implements CustomerDao {

	@Override
	public void create(Customer customer) {
		persistEntity(customer);
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
	public List<Customer> findAll() {
		Criteria criteria = getSession().createCriteria(Customer.class);
		return (List<Customer>) criteria.list();
	}

	@Override
	public void delete(Customer customer) {
		super.deleteEntity(customer);
	}

}
