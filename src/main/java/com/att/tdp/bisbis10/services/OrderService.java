package com.att.tdp.bisbis10.services;

import com.att.tdp.bisbis10.entities.OrderEntity;
import com.att.tdp.bisbis10.repositories.OrderRepository;
import com.att.tdp.bisbis10.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public OrderEntity addOrder(OrderEntity order) {
        if (!restaurantRepository.existsById(order.getRestaurantId())) {
            throw new IllegalArgumentException("Restaurant not found");
        }
        return orderRepository.save(order);
    }
}
