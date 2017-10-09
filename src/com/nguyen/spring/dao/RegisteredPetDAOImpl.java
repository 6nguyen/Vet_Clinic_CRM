package com.nguyen.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nguyen.spring.entity.RegisteredPet;

// add repo annotation to all DAO implementations
@Repository
public class RegisteredPetDAOImpl implements RegisteredPetDAO {

	// inject SessionFactory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<RegisteredPet> getPets() {
		
		// get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		Query<RegisteredPet> theQuery = currentSession.createQuery("FROM RegisteredPet ORDER BY species", RegisteredPet.class);
		
		// execute query and get result list
		List<RegisteredPet> registeredPets = theQuery.getResultList();
		
		// return the results
		return registeredPets;
	}

}
