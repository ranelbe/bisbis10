package com.att.tdp.bisbis10.services;

import com.att.tdp.bisbis10.Constants;
import com.att.tdp.bisbis10.entities.OrderEntity;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.repositories.OrderRepository;
import com.att.tdp.bisbis10.repositories.RestaurantRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public OrderEntity addOrder(OrderEntity order) {
        Long restaurantId = order.getRestaurantId();
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new EntityNotFoundException(Constants.RESTAURANT_NOT_FOUND + restaurantId));
        order.setRestaurant(restaurant);
        return orderRepository.save(order);
    }
}
