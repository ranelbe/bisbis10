package com.att.tdp.bisbis10.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "name field is mandatory")
    private String name;

    @NotNull(message = "isKosher field is mandatory")
    private Boolean isKosher;

    @NotEmpty(message = "cuisines field is mandatory")
    @ElementCollection
    private List<String> cuisines;

    public Restaurant() {
    }

    public Restaurant(String name, Boolean isKosher, List<String> cuisines) {
        this.name = name;
        this.isKosher = isKosher;
        this.cuisines = cuisines;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isKosher() {
        return this.isKosher;
    }

    public void setIsKosher(Boolean isKosher) {
        this.isKosher = isKosher;
    }

    public List<String> getCuisines() {
        return this.cuisines;
    }

    public void setCuisines(List<String> cuisines) {
        this.cuisines = cuisines;
    }

}
