package com.att.tdp.bisbis10.controllers;

import com.att.tdp.bisbis10.entities.OrderEntity;
import com.att.tdp.bisbis10.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * add new order
     * @param order order to add
     * @return added order
     */
    @PostMapping
    public ResponseEntity<Map<String, String>> addOrder(@RequestBody OrderEntity order) {
        // Save the entity
        OrderEntity addedOrder = orderService.addOrder(order);
        // Construct the response
        Map<String, String> response = new HashMap<>();
        response.put("orderId", addedOrder.getOrderId());
        return ResponseEntity.ok(response);
    }
}
