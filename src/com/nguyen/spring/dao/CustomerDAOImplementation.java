package com.nguyen.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nguyen.spring.entity.Customer;

// Add repo annotation for every DAO implementation
@Repository
public class CustomerDAOImplementation implements CustomerDAO{

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		// get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		Query<Customer> theQuery = currentSession.createQuery("FROM Customer ORDER BY lastName", Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		// return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the customer to db with Hibernate's saveOrUpdate()
		// Hibernate looks at customer's Primary Key, if null it creates creates a new user with insert()
		// if Primary Key != null, calls update()
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve object from the db using theId
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create HQL query to delete using Primary Key id
		Query<Customer> theQuery = currentSession.createQuery("DELETE FROM Customer WHERE id=:customerIdParam");
		
		// Set customerId parameter in HQL query
		theQuery.setParameter("customerIdParam", theId);
		
		// execute the HQL query
		theQuery.executeUpdate();
		}

}







