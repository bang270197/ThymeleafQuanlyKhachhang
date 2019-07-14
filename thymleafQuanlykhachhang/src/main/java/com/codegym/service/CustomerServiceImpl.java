package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.persistence.CustomerPersistenceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class CustomerServiceImpl implements service<Customer> {
    @Autowired
    private CustomerPersistenceImpl customerPersistence;

    @Override
    public ArrayList<Customer> findAll() {
        return customerPersistence.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerPersistence.findById(id);
    }

    @Override
    public Customer findByName(String name) {
        return customerPersistence.findByName(name);
    }

    @Override
    public void save(Customer customer) {
        customerPersistence.save(customer);
    }

    @Override
    public void edit(Customer customer) {
        customerPersistence.edit(customer);
    }

    @Override
    public void remove(int id) {
        customerPersistence.remove(id);
    }
}
