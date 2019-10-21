package com.gft.examen.feignservice.client;

import com.gft.examen.feignservice.model.Customer;
import com.gft.examen.feignservice.request.CustomerRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient (name= "customer-service", url = "http://customer-service.eastus.azurecontainer.io:8092", qualifier ="customerClientRest" )
public interface CustomerClientRest {

    @PostMapping(value = "/customer")
    void createCustomer (@RequestBody CustomerRequest customerRequest);

    @GetMapping(value = "/customer")
    List<Customer> getCustomers ();

    @PutMapping(value = "/customer/{customerId}")
    void updateCustomersById (@PathVariable("customerId") String customerId, @RequestBody CustomerRequest customerRequest);

    @DeleteMapping (value = "/customer/{customerId}")
    void deleteCustomersById (@PathVariable("customerId") String customerId);
}
