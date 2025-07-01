package com.managing_advertisements.first_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managing_advertisements.first_project.dal.CustomerRepository;
import com.managing_advertisements.first_project.model.Customer;
// import com.managing_advertisements.first_project.model.users;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    @Override
    public List<Customer> getAll() {
        return (List<Customer>) customerRepo.findAll();
    }
}
