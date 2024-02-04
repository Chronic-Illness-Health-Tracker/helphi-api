package com.helphi.api;

import jakarta.persistence.*;
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
@Entity
@Table(name="address", schema="helphi")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    @Size(max = 35, message = "address line one should not be greater than 35 characters")
    @ColumnTransformer(write = "INITCAP(?)")
    @Column(name = "address_line_one")
    private String addresslineOne;
    @ColumnTransformer(write = "INITCAP(?)")
    @Size(max = 35, message = "address line two should not be greater than 35 characters")
    @Column(name = "address_line_two")
    private String addresslineTwo;
    @Size(max = 8, message = "postcode should not be greater than 8 characters")
    @ColumnTransformer(write = "UPPER(REPLACE(?,' ',''))")
    @Column(name = "postcode")
    private String postcode;
}
