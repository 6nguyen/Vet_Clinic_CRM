package com.nguyen.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nguyen.spring.dao.CustomerDAO;
import com.nguyen.spring.entity.Customer;
import com.nguyen.spring.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// inject CustomerService
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model myModel){
		
		// get customers from the DAO
		List<Customer> customerList = customerService.getCustomers();
		
		// add customers to the model, using attribute name customers
		myModel.addAttribute("customers", customerList);
		
		return "list-customers";
	}
	
	
	@GetMapping("/addCustomer")
	public String addCustomer(Model myModel){
		
		// create Model attribute to bind form data
		Customer theCustomer = new Customer();
		myModel.addAttribute("customer", theCustomer);
		
		
		return "customer-form";
	}
	
}
