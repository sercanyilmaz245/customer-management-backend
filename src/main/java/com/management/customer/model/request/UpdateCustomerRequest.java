package com.management.customer.model.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateCustomerRequest extends AddCustomerRequest {

    private Long id;

    public UpdateCustomerRequest(Long id) {
        this.id = id;
    }
}
