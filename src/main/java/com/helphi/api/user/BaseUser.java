package com.helphi.api.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnTransformer;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name="user_id")
    private UUID userId;
    @Size(max = 320, message = "email should not be greater than 320 characters")
    @Email(message = "email is not valid")
    @Column(name="email")
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(name="title")
    @ColumnTransformer(write = "?::user_title")
    private Title title;
    @Size(max = 35, message = "forname should not be greater than 35 characters")
    @Column(name="forename")
    private String forename;
    @Size(max = 35, message = "middlenames should not be greater than 35 characters")
    @Column(name="middlenames")
    private String middlenames;
    @Size(max = 35, message = "lastname should not be greater than 35 characters")
    @Column(name="lastname")
    private String lastname;
    @Column(name="contact_number")
    @Size(max = 15, message = "Contact number should not be greater than 15 characters")
    private String contactNumber;
    @Size(max = 15, message = "Contact number should not be greater than 15 characters")
    @Column(name="alternate_contact_number")
    private String alternateContactNumber;
}
