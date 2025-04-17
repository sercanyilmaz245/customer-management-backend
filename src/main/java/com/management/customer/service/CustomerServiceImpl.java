package com.management.customer.service;

import com.management.customer.dao.CustomerDAO;
import com.management.customer.exceptionhandler.exception.AlreadyDeletedException;
import com.management.customer.exceptionhandler.exception.DuplicateException;
import com.management.customer.exceptionhandler.exception.ResourceNotFoundException;
import com.management.customer.model.dto.CustomerDTO;
import com.management.customer.model.entity.Customer;
import com.management.customer.model.request.AddCustomerRequest;
import com.management.customer.model.request.UpdateCustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public void addCustomer(AddCustomerRequest addCustomerRequest) {
        Optional<Customer> optionalCustomer = customerDAO.findByIdentificationNumberOrEmail
                (addCustomerRequest.getIdentificationNumber(), addCustomerRequest.getEmail());
        if (optionalCustomer.isPresent()) {
            throw new DuplicateException("User already exists");
        }

        Customer customer = Customer.builder()
                .name(addCustomerRequest.getName())
                .surname(addCustomerRequest.getSurname())
                .identificationNumber(addCustomerRequest.getIdentificationNumber())
                .registerDate(LocalDate.parse(addCustomerRequest.getRegisterDate()))
                .address(addCustomerRequest.getAddress())
                .city(addCustomerRequest.getCity())
                .email(addCustomerRequest.getEmail())
                .phoneNumber(addCustomerRequest.getPhoneNumber())
                .build();

        customerDAO.save(customer);
    }

    @Override
    public Customer updateCustomer(UpdateCustomerRequest updateCustomerRequest) {
        Optional<Customer> optionalCustomer = customerDAO.findById(updateCustomerRequest.getId());
        if (optionalCustomer.isEmpty()) {
            throw new ResourceNotFoundException("User not found");
        }

        Customer customer = optionalCustomer.get();
        customer.setName(updateCustomerRequest.getName());
        customer.setSurname(updateCustomerRequest.getSurname());
        customer.setIdentificationNumber(updateCustomerRequest.getIdentificationNumber());
        customer.setRegisterDate(LocalDate.parse(updateCustomerRequest.getRegisterDate()));
        customer.setAddress(updateCustomerRequest.getAddress());
        customer.setCity(updateCustomerRequest.getCity());
        customer.setEmail(updateCustomerRequest.getEmail());
        customer.setPhoneNumber(updateCustomerRequest.getPhoneNumber());

        return customerDAO.save(customer);
    }

    @Override
    public void deleteCustomer(Long userId) {
        Optional<Customer> optionalCustomer = customerDAO.findById(userId);
        if (optionalCustomer.isEmpty()) {
            throw new ResourceNotFoundException("User not found");
        }
        Customer customer = optionalCustomer.get();
        if (customer.isDeleted()) {
            throw new AlreadyDeletedException("User already deleted");
        }
        customer.setDeleted(true);
        customerDAO.save(customer);
    }

    @Override
    public Page<CustomerDTO> getAllCustomers(Integer page) {
        return customerDAO.getAllCustomers(page);
    }
}
