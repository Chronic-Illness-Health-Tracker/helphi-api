package com.helphi.api;

import com.helphi.api.user.Title;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.ColumnTransformer;

import java.util.UUID;

@Entity
@Data
@Table(name="gp", schema="helphi")
public class Gp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name="title")
    @ColumnTransformer(write = "?::user_title")
    private Title title;

    @Size(max = 45, message = "forename should not be greater than 45 characters")
    @Column(name="forename")
    private String forename;

    @Size(max = 45, message = "middle names should not be greater than 45 characters")
    @Column(name="middlenames")
    private String middlenames;

    @Size(max = 45, message = "lastname should not be greater than 45 characters")
    @Column(name="lastname")
    private String lastname;

    @Size(max = 320, message = "email address should not be greater than 320 characters")
    @Email(message = "email is not valid")
    @Column(name="email")
    private String email;

    @Column(name = "contact_number")
    @Size(max = 15, message = "contact number should not be greater than 15 characters")
    private String contactNumber;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "surgery_id", referencedColumnName = "id")
    private GpSurgery surgery;
}
