package com.ofss.main.service;

import com.ofss.main.domain.Customer;

public interface CustomerService {
	Customer getCustomerbyCustomerId(int customerId);
    Customer addNewCustomer(Customer customer);

}
