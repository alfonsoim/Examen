package com.gft.examen.customerservice.service;

import com.gft.examen.customerservice.model.Customer;
import com.gft.examen.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service ("customerService")
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl (CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }

    @Override
    public void createCustomer(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void updateCustomersById(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public void deleteCustomersById(String id) {
        this.customerRepository.deleteById(id);
    }
}
