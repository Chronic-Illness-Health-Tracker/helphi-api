package com.helphi.api;

import com.helphi.api.organisation.Organisation;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name="health_condition", schema="helphi")
public class HealthCondition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organisation_id", referencedColumnName = "id")
    private Organisation organisation;
    @Size(max = 45, message = "condition name should not be greater than 45 characters")
    private String name;

    @Column(name="short_name")
    @Size(max = 5, message = "short name should not be greater than 5 characters")
    private String shortName;
}
