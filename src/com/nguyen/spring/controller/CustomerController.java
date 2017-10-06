package com.nguyen.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nguyen.spring.dao.CustomerDAO;
import com.nguyen.spring.entity.Customer;
import com.nguyen.spring.entity.RegisteredPet;
import com.nguyen.spring.service.CustomerService;
import com.nguyen.spring.service.RegisteredPetService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// inject CustomerService
	@Autowired
	private CustomerService customerService;
	// inject RegisteredPetService
	@Autowired
	private RegisteredPetService registeredPetService;
	
	@GetMapping("/list")
	public String listCustomers(Model myModel){
		
		// get customers from the DAO
		List<Customer> customerList = customerService.getCustomers();
		
		// add customers to the model, using attribute name customers
		myModel.addAttribute("customers", customerList);
		
		// get registeredPets from DAO
		List<RegisteredPet> petList = registeredPetService.getPets();
		
		myModel.addAttribute("registeredPets", petList);
		
		return "list-customers";
	}
	
	
	@GetMapping("/addCustomer")
	public String addCustomer(Model myModel){
		
		// create Model attribute to bind form data
		Customer theCustomer = new Customer();
		myModel.addAttribute("customer", theCustomer);
		
		
		return "customer-form";
	}
	
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer ){
		
		// save the customer using Customer Service
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/updateCustomer")
	public String updateCustomer(@RequestParam("customerId") int theId, Model myModel ){
		
		// get customer from our service
		Customer theCustomer = customerService.getCustomer(theId);
		
		// set customer as a model attribute to pre-populate form
		myModel.addAttribute("customer", theCustomer);
		
		// send over to our form
		return "customer-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		// delete the customer
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
	
	
	
	// RegisteredPet mapping
	@GetMapping("/list/pets")
	public String listPets(Model myModel){
		
		// get registeredPets from DAO
		List<RegisteredPet> petList = registeredPetService.getPets();
		
		myModel.addAttribute("registeredPets", petList);
		
		return "list-pets";
	}
}
