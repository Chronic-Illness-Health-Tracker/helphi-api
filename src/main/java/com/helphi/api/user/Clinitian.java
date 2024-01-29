package com.helphi.api.user;

import com.helphi.api.organisation.Organisation;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Table(name="clinitian", schema="helphi")
public class Clinitian extends User {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organisation_id", referencedColumnName = "id")
    private Organisation organisation;
    public Clinitian(UUID id,
                     String email,
                     String title,
                     String firstname,
                     String middlenames,
                     String lastname,
                     String contactNumber,
                     String alternateContactNumber,
                     Date dateOfBirth) {
        super(id, email, title, firstname,middlenames, lastname, contactNumber, alternateContactNumber);
    }
}
