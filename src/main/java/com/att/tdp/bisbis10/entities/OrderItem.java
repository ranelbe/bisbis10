package com.att.tdp.bisbis10.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "dishId field is mandatory")
    private Long dishId;

    @NotNull(message = "amount field is mandatory")
    private Integer amount;

    public OrderItem() {
    }

    public OrderItem(Long dishId, Integer amount) {
        this.dishId = dishId;
        this.amount = amount;
    }

    // Getters and setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDishId() {
        return this.dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}
