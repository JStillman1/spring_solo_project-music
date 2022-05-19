package com.example.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Composer {

    //Properties


    private Long id;

    private String firstName;
    private String lastName;
    private Date dob;
    private List<Music> compositions;


    //Constructors


    public Composer() {
    }

    public Composer(Long id, String firstName, String lastName, Date dob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.compositions = new ArrayList<>();
    }

    //Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public List<Music> getCompositions() {
        return compositions;
    }

    public void setCompositions(List<Music> compositions) {
        this.compositions = compositions;
    }
}
