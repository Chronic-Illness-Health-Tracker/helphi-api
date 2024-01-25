package com.helphi.api;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Gp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String title;
    private String forename;
    private String middlenames;
    private String lastname;
    private String email;

    @Column(name = "contact_number")
    private String contactNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "surgery_id", referencedColumnName = "id")
    private GpSurgery surgery;
}
