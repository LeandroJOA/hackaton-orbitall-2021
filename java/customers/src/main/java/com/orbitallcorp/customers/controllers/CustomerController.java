package com.orbitallcorp.customers.controllers;

import com.orbitallcorp.customers.domains.Customer;
import com.orbitallcorp.customers.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> save(@RequestBody Customer customer) {

        Customer savedCustomer = customerService.save((customer));

        return new ResponseEntity(savedCustomer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> findAll() {

        List<Customer> customers = customerService.finAll();
        return ResponseEntity.ok(customers);
    }
}

