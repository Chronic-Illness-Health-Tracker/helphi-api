package com.helphi.api.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class User {
    private String id;
    private String email;
    private String firstname;
    private String middlenames;
    private String lastname;
    private String contactNumber;
    private String alternateContactNumber;
    private Date dateOfBirth;


}
