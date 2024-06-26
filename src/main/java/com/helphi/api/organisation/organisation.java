package com.helphi.api.organisation;

import com.helphi.api.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="organisation", schema="helphi")
public class Organisation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    @Size(max = 45, message = "organisation name should not be greater than 45 characters")
    @Column(name = "name")
    private String name;
    @Size(max = 320, message = "contact email name should not be greater than 320 characters")
    @Email(message = "email is not valid")
    @Column(name = "email")
    private String email;
    @Size(max = 35, message = "country code should not be greater than 6 characters")
    @Column(name="country_code")
    private String countryCode;
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "address_id"))
    private Address contactAddress;
    @Size(max = 15, message = "contact number cannot be over 15 characters long")
    @Column(name="contact_number")
    private String contactNumber;
}
