package com.management.customer.service;

import com.management.customer.model.request.AuthRequest;
import com.management.customer.model.request.UpdatePasswordRequest;

public interface UserService {

    void updatePassword(UpdatePasswordRequest request);

    void register(AuthRequest request);
}
