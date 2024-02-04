package com.helphi.api;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name="gp_surgery", schema="helphi")
public class GpSurgery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Size(max = 35, message = "surgery name should not be greater than 45 characters")
    @Column(name="name")
    private String name;

    @Size(max = 320, message = "email address should not be greater than 320 characters")
    @Email(message = "email is not valid")
    @Column(name="email")
    private String email;

    @Column(name="country_code")
    @Size(max = 6, message = "country code should not be greater than 6 characters")
    private String countryCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "address_id"))
    private Address address;

    @Column(name="contact_number")
    @Size(max = 15, message = "contact number should not be greater than 15 characters")
    private String contactNumber;
}
