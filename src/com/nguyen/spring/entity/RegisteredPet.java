package com.nguyen.spring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * MySQL, registered_pet table has a 1:1 bidirectional relationship with customer table
 * 
 * Step 1) Annotate class as @Entity so we can map Class member variables with db fields
 * Step 2) Map the member variables to their corresponding fields
 * Step 3) Create default and eclipse generated Constructors (don't include id, since it's auto generated)
 * Step 4) Generate Getters/Setters
 * Step 5) Generate toString() method
 */

@Entity
@Table(name="registered_pet")
public class RegisteredPet {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="species")
	private String species;
	@Column(name="breed")
	private String breed;
	@Column(name="name")
	private String name;
	
//	// Add mapping in RegisteredPet to make the relationship BIdirectional
	@OneToOne(mappedBy="registeredPet", cascade=CascadeType.ALL)
	private Customer customer;
	
	// CONSTRUCTORS:
	public RegisteredPet(){
		
	}

	public RegisteredPet(String species, String breed, String name) {
		this.species = species;
		this.breed = breed;
		this.name = name;
	}

	// GETTERS & SETTERS:
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
//
//	@Override
//	public String toString() {
//		return "RegisteredPet [id=" + id + ", species=" + species + ", breed=" + breed + ", name=" + name
//				+ ", customer=" + customer + "]";
//	}
	
	
}




