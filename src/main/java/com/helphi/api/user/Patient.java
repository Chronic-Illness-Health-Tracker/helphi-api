package com.helphi.api.user;

import com.helphi.api.GpSurgery;
import com.helphi.api.HealthCondition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Patient extends User {
    private String nhsNumber;
    private GpSurgery gpSurgery;
    private List<HealthCondition> conditions;
    public Patient(String nhsNumber, GpSurgery gpSurgery, List<HealthCondition> conditions) {
        super();
        this.nhsNumber = nhsNumber;
        this.gpSurgery = gpSurgery;
        this.conditions = conditions;


    }
}
