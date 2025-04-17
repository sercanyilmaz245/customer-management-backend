package com.management.customer.repository;

import com.management.customer.model.dto.CustomerDTO;
import com.management.customer.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByIdentificationNumberOrEmail(String idNo, String email);

    @Query("select new com.management.customer.model.dto.CustomerDTO(" +
            "c.id," +
            "c.name," +
            "c.surname," +
            "c.identificationNumber," +
            "c.registerDate," +
            "c.address," +
            "c.city," +
            "c.email," +
            "c.phoneNumber" +
            ") from Customer c where c.deleted = false")
    Page<CustomerDTO> findAllBy(Pageable pageable);
}
