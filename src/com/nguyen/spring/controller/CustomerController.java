package com.nguyen.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nguyen.spring.dao.CustomerDAO;
import com.nguyen.spring.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// inject CustomerDAO into controller
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model myModel){
		
		// get customers from the DAO
		List<Customer> customerList = customerDAO.getCustomers();
		
		// add customers to the model
		myModel.addAttribute("customers", customerList);
		
		return "list-customers";
	}
}
