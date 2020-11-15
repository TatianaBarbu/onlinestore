package com.sda.onlinestore.dto;

public class AuthorDTO {

    private String firstName;
    private String lastName;

    public AuthorDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public AuthorDTO() {
    }

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
