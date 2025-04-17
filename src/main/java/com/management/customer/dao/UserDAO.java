package com.management.customer.dao;

import com.management.customer.model.entity.User;

import java.util.Optional;

public interface UserDAO {
    Optional<User> findByUsername(String username);

    void save(User user);
}
