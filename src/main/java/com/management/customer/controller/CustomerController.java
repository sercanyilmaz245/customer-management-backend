package com.management.customer.controller;

import com.management.customer.model.dto.CustomerDTO;
import com.management.customer.model.entity.Customer;
import com.management.customer.model.request.AddCustomerRequest;
import com.management.customer.model.request.UpdateCustomerRequest;
import com.management.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("add")
    public ResponseEntity<?> addCustomer(@RequestBody AddCustomerRequest addCustomerRequest) {
        customerService.addCustomer(addCustomerRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<?> updateCustomer(@RequestBody UpdateCustomerRequest updateCustomerRequest) {
        Customer customer = customerService.updateCustomer(updateCustomerRequest);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable(name = "id") Long userId) {
        customerService.deleteCustomer(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAllCustomers(@RequestParam(name = "page", defaultValue = "0") int page) {
        Page<CustomerDTO> customerDTOPage = customerService.getAllCustomers(page);
        return new ResponseEntity<>(customerDTOPage, HttpStatus.OK);
    }
}
