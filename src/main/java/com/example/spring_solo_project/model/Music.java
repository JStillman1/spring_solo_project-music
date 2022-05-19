package com.example.spring_solo_project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Music {
    //Properties

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String title;
    private int yearOfComposition;
    private String style;

    @ManyToOne
    @JsonIgnoreProperties
    private Composer composer;

    //Constructors
    public Music() {
    }

    public Music(Long id, String title, int yearOfComposition, String style, Composer composer) {
        this.id = id;
        this.title = title;
        this.yearOfComposition = yearOfComposition;
        this.style = style;
        this.composer = composer;
    }


    //Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfComposition() {
        return yearOfComposition;
    }

    public void setYearOfComposition(int yearOfComposition) {
        this.yearOfComposition = yearOfComposition;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Composer getComposer() {
        return composer;
    }

    public void setComposer(Composer composer) {
        this.composer = composer;
    }
}
