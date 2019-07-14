package com.codegym.persistence;

import com.codegym.model.Customer;

import java.util.ArrayList;

public class CustomerPersistenceImpl implements persistence<Customer> {
    private static ArrayList<Customer> customers = new ArrayList<>();

    {
        customers.add(new Customer(1, "Bang", "bang270197@gmai.com", "hanoi"));
        customers.add(new Customer(2, "nam", "nam270197@gmai.com", "Ho Chi Minh"));
        customers.add(new Customer(3, "hung", "hung270197@gmai.com", "Da Nang"));
        customers.add(new Customer(4, "kien", "kieb270197@gmai.com", "Hue"));
    }

    @Override
    public ArrayList<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findById(int id) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == id) {
                return customers.get(i);
            }
        }
        return null;
    }

    @Override
    public Customer findByName(String name) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(name)) {
                return customers.get(i);
            }
        }
        return null;
    }

    @Override
    public void save(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void edit(Customer customer) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == customer.getId()) {
                customers.set(i, customer);
            }
        }
    }

    @Override
    public void remove(int id) {
        for (int i=0;i<customers.size();i++){
            if (customers.get(i).getId()==id){
                customers.remove(customers.get(i));
            }
        }

    }
}
