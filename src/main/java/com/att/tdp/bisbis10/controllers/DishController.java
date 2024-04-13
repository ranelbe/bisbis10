package com.att.tdp.bisbis10.controllers;

import com.att.tdp.bisbis10.entities.Dish;
import com.att.tdp.bisbis10.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants/{restaurantId}/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    /**
     * Get all dishes by restaurant
     * @param restaurantId the restaurant id
     * @return a list of dishes
     */
    @GetMapping
    public ResponseEntity<List<Dish>> getDishesByRestaurant(@PathVariable Long restaurantId) {
        return ResponseEntity.ok(dishService.getDishesByRestaurant(restaurantId));
    }

    /**
     * Add a dish to a restaurant
     * @param restaurantId the restaurant id
     * @param dish the dish to add
     * @return the added dish
     */
    @PostMapping
    public ResponseEntity<Dish> addDish(@PathVariable Long restaurantId,
                                        @RequestBody Dish dish) {
        return new ResponseEntity<>(dishService.addDish(restaurantId, dish), HttpStatus.CREATED);
    }

    /**
     * Update a dish
     * @param restaurantId the restaurant id
     * @param dishId the dish id
     * @param dish the dish to update
     * @return the updated dish
     */
    @PutMapping("/{dishId}")
    public ResponseEntity<Dish> updateDish(@PathVariable Long restaurantId,
                                           @PathVariable Long dishId,
                                           @RequestBody Dish dish) {
        return ResponseEntity.ok(dishService.updateDish(restaurantId, dishId, dish));
    }

    /**
     * Delete a dish
     * @param restaurantId the restaurant id
     * @param dishId the dish id
     * @return the deleted dish
     */
    @DeleteMapping("/{dishId}")
    public ResponseEntity<String> deleteDish(@PathVariable Long restaurantId,
                                           @PathVariable Long dishId) {
        return ResponseEntity.ok(dishService.deleteDish(restaurantId, dishId));
    }

}
