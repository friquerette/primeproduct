package com.friquerette.primejs.core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.friquerette.primejs.core.entity.Customer;

@Repository("customerDao")
public class CustomerDaoImpl extends AbstractDao<Customer> implements CustomerDao {

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

	/**
	 * A temporally method until the bug on
	 * "findByFilter(Map<String, String> filter)" is fix
	 */
	@Override
	@Deprecated
	public Customer findByLogin(String username) {
		Criteria criteria = getSession().createCriteria(Customer.class);
		criteria.add(Restrictions.eq("userName", username));
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

	/**
	 * To fixe later : this method works with spring 3 and hibernate 4 but
	 * generate this exception with hibernate4/spring4 :
	 * 
	 * Etat HTTP 500 - Handler processing failed; nested exception is
	 * java.lang.NoSuchMethodError:
	 * org.hibernate.Session.createQuery(Ljava/lang/String;)Lorg/hibernate/query
	 * /Query;
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Deprecated
	public List<Customer> findByFilter(Map<String, String> filter) {
		Map<String, String> parameters = new HashMap<>();
		String queryString = "FROM Customer c WHERE 1 = 1";
		for (Map.Entry<String, String> entry : filter.entrySet()) {
			if (FILTER_USERNAME.equals(entry.getKey())) {
				queryString += " AND c.username=:username ";
				parameters.put("username", entry.getValue());
			}
		}
		Query query = getSession().createQuery(queryString);
		fillQueryWithParameter(query, parameters);
		return query.list();
	}

}
