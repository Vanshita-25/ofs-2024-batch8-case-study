package com.ofss.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.domain.Customer;
import com.ofss.main.service.CustomerService;

@RequestMapping("banking")
@RestController
@CrossOrigin("*")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	//http://localhost:8080/banking/customer/15
		@GetMapping("customer/{customerId}")
		public Customer getCustomerFromDb(@PathVariable int customerId) {
			return customerService.getCustomerbyCustomerId(customerId);
		
		}
		
		@PostMapping("customer")
		public Customer insertEmployeeToDb(@RequestBody Customer customer){
			return customerService.addNewCustomer(customer);
		}
}
