package com.helphi.api.user;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnTransformer;

import java.util.UUID;

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Size(max = 35, message = "username should not be greater than 35 characters")
    @Column(name = "username")
    private String username;
}
