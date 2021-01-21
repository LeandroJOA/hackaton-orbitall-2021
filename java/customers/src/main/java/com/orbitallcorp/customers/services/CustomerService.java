package com.orbitallcorp.customers.services;

import com.orbitallcorp.customers.domains.Customer;
import com.orbitallcorp.customers.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        return customerRepository.save((customer));
    }

    public List<Customer> finAll() {
        List<Customer> customers = new ArrayList<>();

        customerRepository.findAll().forEach(customers :: add);

        return customers;
    }
}
