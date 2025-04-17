package com.management.customer.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "customer", indexes = {
        @Index(name = "customer_email_index", columnList = "email"),
        @Index(name = "customer_identification_number_index", columnList = "identificationNumber")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column(unique = true)
    private String identificationNumber;

    @Column
    private LocalDate registerDate;

    @Column(length = 500)
    private String address;

    @Column
    private String city;

    @Column(unique = true)
    private String email;

    @Column
    private String phoneNumber;

    @Column
    private boolean deleted;
}
