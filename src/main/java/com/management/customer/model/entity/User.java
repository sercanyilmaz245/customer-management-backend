package com.management.customer.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "panel_user", indexes = {
        @Index(name = "panel_user_id_index", columnList = "id")
})
@Data
public class User {

    @Id
    private Long id = 1L; // one user for panel

    @Column
    private String username;

    @Column
    private String password;
}
