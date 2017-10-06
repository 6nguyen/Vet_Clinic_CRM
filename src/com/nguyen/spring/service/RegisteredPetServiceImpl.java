package com.nguyen.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.nguyen.spring.dao.RegisteredPetDAO;
import com.nguyen.spring.entity.RegisteredPet;

public class RegisteredPetServiceImpl implements RegisteredPetService {

	@Autowired
	private RegisteredPetDAO registeredPetDAO;
	
	@Override
	@Transactional
	public List<RegisteredPet> getPets() {
		return registeredPetDAO.getPets();
	}

}
