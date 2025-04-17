package com.management.customer.dao;

import java.util.Optional;

public interface DAO<T, ID> {

    T save(T t);

    Optional<T> findById(ID id);
}
