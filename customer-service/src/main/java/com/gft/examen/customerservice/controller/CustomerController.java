package com.gft.examen.customerservice.controller;

import com.gft.examen.customerservice.model.Customer;
import com.gft.examen.customerservice.request.CustomerRequest;
import com.gft.examen.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController (@Qualifier("customerService") CustomerService customerService)
    {
        this.customerService = customerService;
    }

    @PostMapping (value = "/customer")
    public ResponseEntity createCustomer(@RequestBody CustomerRequest request)
    {
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setLastName(request.getLastName());
        customer.setBirthday(request.getBirthday());
        customer.setGender(request.getGender());
        customerService.createCustomer(customer);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping (value = "/customer")
    public List<Customer> getCustomers ()
    {
        return customerService.getCustomers();
    }

    @PutMapping (value = "/customer/{customerId}")
    public ResponseEntity updateCustomerById (@PathVariable("customerId") String customerId, @RequestBody CustomerRequest request)
    {
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setLastName(request.getLastName());
        customer.setBirthday(request.getBirthday());
        customer.setGender(request.getGender());
        customer.set_id(customerId);
        customerService.updateCustomersById(customer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping (value = "/customer/{customerId}")
    public ResponseEntity deleteCustomersById (@PathVariable("customerId") String customerId)
    {
        customerService.deleteCustomersById(customerId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
