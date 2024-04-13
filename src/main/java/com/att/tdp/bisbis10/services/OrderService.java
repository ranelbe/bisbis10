package com.att.tdp.bisbis10.services;

import com.att.tdp.bisbis10.entities.OrderEntity;
import com.att.tdp.bisbis10.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderEntity addOrder(OrderEntity order) {
        return orderRepository.save(order);
    }

}
