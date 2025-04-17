package com.management.customer.dao;

import com.management.customer.model.dto.CustomerDTO;
import com.management.customer.model.entity.Customer;
import com.management.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    private final CustomerRepository customerRepository;
    private final static int PAGE_SIZE = 10;

    @Autowired
    public CustomerDAOImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Optional<Customer> findByIdentificationNumberOrEmail(String idNo, String email) {
        return customerRepository.findByIdentificationNumberOrEmail(idNo, email);
    }

    @Override
    public Page<CustomerDTO> getAllCustomers(Integer page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE, Sort.by(Sort.Direction.DESC, "id"));
        return customerRepository.findAllBy(pageable);
    }
}
