package com.ofss.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ofss.main.domain.Customer;

@Component
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}
