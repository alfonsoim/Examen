package com.gft.examen.customerservice.service;

import com.gft.examen.customerservice.model.Customer;
import com.gft.examen.customerservice.request.CustomerRequest;

import java.util.List;

public interface CustomerService {

    void createCustomer (Customer customer);

    List<Customer> getCustomers ();

    void updateCustomersById (Customer customer);

    void deleteCustomersById (String id);
}
