package com.helphi.api.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String email;
    private String title;
    private String forename;
    private String middlenames;
    private String lastname;
    @Column(name="contact_number")
    private String contactNumber;
    @Column(name="alternative_contact_number")
    private String alternateContactNumber;
}
