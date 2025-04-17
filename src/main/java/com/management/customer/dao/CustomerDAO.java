package com.management.customer.dao;

import com.management.customer.model.dto.CustomerDTO;
import com.management.customer.model.entity.Customer;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface CustomerDAO extends DAO<Customer, Long> {
    Optional<Customer> findByIdentificationNumberOrEmail(String idNo, String email);

    Page<CustomerDTO> getAllCustomers(Integer page);
}
