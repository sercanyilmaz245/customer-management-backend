package com.management.customer.model.request;

import lombok.Data;

@Data
public class AddCustomerRequest {

    private String name;
    private String surname;
    private String identificationNumber;
    private String registerDate;
    private String address;
    private String city;
    private String email;
    private String phoneNumber;
}
