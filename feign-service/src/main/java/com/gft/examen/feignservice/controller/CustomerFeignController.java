package com.gft.examen.feignservice.controller;

import com.gft.examen.feignservice.model.Customer;
import com.gft.examen.feignservice.request.CustomerRequest;
import com.gft.examen.feignservice.service.CustomerFeignService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(tags = "Customer")
public class CustomerFeignController {

    private CustomerFeignService customerServiceFeign;
    @Autowired
    public CustomerFeignController(@Qualifier("customerFeignService") CustomerFeignService customerServiceFeign)
    {
        this.customerServiceFeign = customerServiceFeign;
    }



    @PostMapping(value = "/customer")
    @ApiOperation(value = "Guarda la informacion del cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 505, message = "Internal error")
    })
    public ResponseEntity createCustomer (@ApiParam(value = "Informaciòn necesaria para dar de alta un cliente", required = true) @Valid @RequestBody CustomerRequest customerRequest)
    {
        customerServiceFeign.createCustomer(customerRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(value = "/customer")
    @ApiOperation(value = "Devuelve una lista de los clientes existentes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 505, message = "Internal error")
    })
    public List<Customer> getCustomers ()
    {
        return customerServiceFeign.getCustomers();
    }

    @PutMapping(value = "/customer/{customerId}")
    @ApiOperation(value = "Actualiza la informacion de un cliente en especifico")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 505, message = "Internal error")
    })
    public ResponseEntity updateCustomersById (@ApiParam(value = "Identificador unico del cliente", required = true) @PathVariable("customerId") String customerId,
                                               @ApiParam(value = "Informaciòn necesaria para actualizar un cliente", required = true) @Valid @RequestBody CustomerRequest customerRequest)
    {
        customerServiceFeign.updateCustomersById(customerId, customerRequest);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping (value = "/customer/{customerId}")
    @ApiOperation(value = "Elimina la informacion de un cliente en especifico")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 505, message = "Internal error")
    })
    public ResponseEntity deleteCustomersById (@ApiParam(value = "Identificador unico del cliente", required = true) @PathVariable("customerId") String customerId)
    {
        customerServiceFeign.deleteCustomersById(customerId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
