package com.att.tdp.bisbis10.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderId;

    @NotNull(message = "restaurantId field is mandatory")
    @Column(name = "restaurant_id", insertable=false, updatable=false)
    private Long restaurantId;

    @NotNull(message = "orderItems field is mandatory")
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    @JsonBackReference
    private Restaurant restaurant;

    public OrderEntity() {
        this.orderId = UUID.randomUUID().toString();
    }

    public OrderEntity(Long restaurantId, List<OrderItem> orderItems) {
        this.restaurantId = restaurantId;
        this.orderItems = orderItems;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long orderId) {
        this.id = orderId;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getRestaurantId() {
        return this.restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<OrderItem> getOrderItems() {
        return this.orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Restaurant getRestaurant() {
        return this.restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

}
