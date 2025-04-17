package com.management.customer.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CustomerDTO {
    private Long id;
    private String name;
    private String surname;
    private String identificationNumber;
    private LocalDate registerDate;
    private String address;
    private String city;
    private String email;
    private String phoneNumber;
}
