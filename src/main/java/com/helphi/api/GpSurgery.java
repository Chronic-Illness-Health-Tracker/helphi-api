package com.helphi.api;


import jakarta.persistence.*;
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
    private String name;
    private String email;

    @Column(name="country_code")
    private String countryCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @Column(name="contact_number")
    private String contactNumber;

    @Column(name="alternative_contact_number")
    private String alternativeContactNumber;

}
