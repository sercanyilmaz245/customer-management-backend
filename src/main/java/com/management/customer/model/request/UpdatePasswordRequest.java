package com.management.customer.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdatePasswordRequest {
    private String username;
    private String oldPassword;
    private String newPassword;
}
