package com.gft.examen.feignservice.service;

import com.gft.examen.feignservice.client.CustomerClientRest;
import com.gft.examen.feignservice.model.Customer;
import com.gft.examen.feignservice.request.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service ("customerFeignService")
public class CustomerFeignServiceImpl implements CustomerFeignService {


    private CustomerClientRest customerClientRest;

    @Autowired
    public CustomerFeignServiceImpl(@Qualifier("customerClientRest") CustomerClientRest customerClientRest)
    {
        this.customerClientRest = customerClientRest;
    }

    @Override
    public void createCustomer(CustomerRequest request) {
        customerClientRest.createCustomer(request);
    }

    @Override
    public List<Customer> getCustomers() {
        return customerClientRest.getCustomers();
    }

    @Override
    public void updateCustomersById(String customerId, CustomerRequest request) {
        customerClientRest.updateCustomersById(customerId, request);
    }

    @Override
    public void deleteCustomersById(String customerId) {
        customerClientRest.deleteCustomersById(customerId);
    }
}
