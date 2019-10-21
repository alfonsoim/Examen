package com.gft.examen.feignservice.service;

import com.gft.examen.feignservice.model.Customer;
import com.gft.examen.feignservice.request.CustomerRequest;

import java.util.List;

public interface CustomerFeignService {

    void createCustomer (CustomerRequest request);

    List<Customer> getCustomers ();

    void updateCustomersById (String customerId, CustomerRequest request);

    void deleteCustomersById (String id);
}
