package com.helphi.api.user;

import com.helphi.api.Address;
import com.helphi.api.Gp;
import com.helphi.api.HealthCondition;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name="patient", schema="helphi")
public class Patient extends BaseUser {
    @Column(name="nhs_number")
    @Size(max = 10, message = "NHS number should not be greater than 10 characters")
    private String nhsNumber;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "gp_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "gp_id"))
    private Gp gp;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "address_id"))
    private Address address;

    @OneToMany
    @JoinTable(
            name = "patient_condition_link",
            schema = "helphi",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "health_condition_id")
    )
    private List<HealthCondition> conditions;

    @Column(name="date_of_birth")
    @Past(message = "date of birth must not be in the future")
    private Date dateOfBirth;

    public Patient(UUID id,
                   UUID userId,
                   String email,
                   Title title,
                   String forename,
                   String middlenames,
                   String lastname,
                   String contactNumber,
                   String alternateContactNumber,
                   Date dateOfBirth,
                   String nhsNumber,
                   Gp gp,
                   List<HealthCondition> conditions) {
        super(id, userId, email, title, forename, middlenames, lastname, contactNumber, alternateContactNumber);
        this.nhsNumber = nhsNumber;
        this.gp = gp;
        this.conditions = conditions;
    }
}
