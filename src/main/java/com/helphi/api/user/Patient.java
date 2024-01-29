package com.helphi.api.user;

import com.helphi.api.Address;
import com.helphi.api.Gp;
import com.helphi.api.HealthCondition;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name="patient", schema="helphi")
public class Patient extends User {
    @Column(name="nhs_number")
    private String nhsNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gp_id", referencedColumnName = "id")
    private Gp gp;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany
    @JoinTable(
            name = "patient_condition_link",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "condition_id")
    )
    private List<HealthCondition> conditions;

    @Column(name="date_of_birth")
    private Date dateOfBirth;

    public Patient(UUID id,
                   String email,
                   String title,
                   String forename,
                   String middlenames,
                   String lastname,
                   String contactNumber,
                   String alternateContactNumber,
                   Date dateOfBirth,
                   String nhsNumber,
                   Gp gp,
                   List<HealthCondition> conditions) {
        super(id, email, title, forename, middlenames, lastname, contactNumber, alternateContactNumber);
        this.nhsNumber = nhsNumber;
        this.gp = gp;
        this.conditions = conditions;
    }
}
