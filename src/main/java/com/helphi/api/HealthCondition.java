package com.helphi.api;

import com.helphi.api.organisation.Organisation;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="health_condition")
public class HealthCondition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organisation_id", referencedColumnName = "id")
    private Organisation organisation;
    private String name;

    @Column(name="short_name")
    private String shortName;
}
