package edu.icet.service;

import edu.icet.model.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(Integer id);


    Customer searchCustomerEmail(String email);

    List<Customer> viewCustomers();

    List<Customer> getByName(String name);
}
