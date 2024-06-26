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
@Table(name="clinician", schema="helphi")
public class Clinician extends BaseUser {

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "organisation_id", referencedColumnName = "id")
    private Organisation organisation;
    public Clinician(UUID id,
                     String userId,
                     String email,
                     Title title,
                     String firstname,
                     String middlenames,
                     String lastname,
                     String contactNumber,
                     String alternateContactNumber) {
        super(id, userId, email, title, firstname,middlenames, lastname, contactNumber, alternateContactNumber);
    }
}
