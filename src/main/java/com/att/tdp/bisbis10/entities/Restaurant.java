package com.att.tdp.bisbis10.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    private Double rating = 0.0;

    @JsonIgnore
    private Integer ratingsAmount = 0;

    @NotNull(message = "isKosher field is mandatory")
    private Boolean isKosher;

    @NotEmpty(message = "cuisines field is mandatory")
    @ElementCollection
    private List<String> cuisines;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Dish> dishes;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<OrderEntity> orders;


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

    public Double getRating() {
        return this.rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getRatingsAmount() {
        return this.ratingsAmount;
    }

    public void setRatingsAmount(Integer ratingsAmount) {
        this.ratingsAmount = ratingsAmount;
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


    public List<Dish> getDishes() {
        return this.dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<OrderEntity> getOrders() {
        return this.orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }

}
