package com.example.jeanc.crud_pessoa;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Pessoas {

    @JsonProperty("ID")
    private Long ID;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    public Pessoas() {
    }


    public Pessoas(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public Long getID() {
        return ID;
    }

    public void setId(Long ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
