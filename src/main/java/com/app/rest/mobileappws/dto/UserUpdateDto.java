package com.app.rest.mobileappws.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserUpdateDto {

    @NotNull
    @Size(min=3, message = "Last Name must be minimum 3 characters")
    private String firstName;

    @NotNull
    @Size(min=3, message = "Last Name must be minimum 3 characters")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
