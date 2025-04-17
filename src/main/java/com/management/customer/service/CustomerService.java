package com.management.customer.service;

import com.management.customer.model.dto.CustomerDTO;
import com.management.customer.model.entity.Customer;
import com.management.customer.model.request.AddCustomerRequest;
import com.management.customer.model.request.UpdateCustomerRequest;
import org.springframework.data.domain.Page;

public interface CustomerService {
    void addCustomer(AddCustomerRequest addCustomerRequest);

    Customer updateCustomer(UpdateCustomerRequest updateCustomerRequest);

    void deleteCustomer(Long userId);

    Page<CustomerDTO> getAllCustomers(Integer page);
}
