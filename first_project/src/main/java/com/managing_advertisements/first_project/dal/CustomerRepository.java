package com.managing_advertisements.first_project.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.managing_advertisements.first_project.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer> {
    
}
