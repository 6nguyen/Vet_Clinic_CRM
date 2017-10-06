package com.nguyen.spring.dao;

import java.util.List;

import com.nguyen.spring.entity.RegisteredPet;

public interface RegisteredPetDAO {

	public List<RegisteredPet> getPets();
}
