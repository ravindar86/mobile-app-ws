package com.app.rest.mobileappws.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto {
    @NotNull
    @Size(min=3, message = "Last Name must be minimum 3 characters")
    private String firstName;

    @NotNull
    @Size(min=3, message = "Last Name must be minimum 3 characters")
    private String lastName;

    @NotNull
    @Email
    private String emailId;

    @NotNull
    @Size(min=5, max=12, message = "Password length must be between 5 and 12 characters")
    private String password;

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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
