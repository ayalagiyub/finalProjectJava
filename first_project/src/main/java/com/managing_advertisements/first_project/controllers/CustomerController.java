package com.managing_advertisements.first_project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.managing_advertisements.first_project.model.Customer;
// import com.managing_advertisements.first_project.model.Customer;
import com.managing_advertisements.first_project.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/Customer")
public class CustomerController {
    @Autowired
    private CustomerService CustomerSrc;

    @GetMapping("/get")
    public List<Customer> getAll() {
    return CustomerSrc.getAll();
    }

    // @PutMapping("path/{id}")
    // public void putMethodName(@RequestBody Customer C) {
    // CustomerSrc.add(C);
    // }
    
}