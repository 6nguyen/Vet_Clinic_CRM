package com.nguyen.spring.service;

import java.util.List;

import com.nguyen.spring.entity.Customer;


public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);
}
