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
     * Add a dish to a restaurant
     * @param restaurantId the restaurant id
     * @param dish the dish to add
     */
    @PostMapping
    public ResponseEntity<Void> addDish(@PathVariable Long restaurantId,
                                        @RequestBody Dish dish) {
        dishService.addDish(restaurantId, dish);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Update a dish
     * @param restaurantId the restaurant id
     * @param dishId the dish id
     * @param dish the dish to update
     */
    @PutMapping("/{dishId}")
    public ResponseEntity<Void> updateDish(@PathVariable Long restaurantId,
                                             @PathVariable Long dishId,
                                             @RequestBody Dish dish) {
        dishService.updateDish(restaurantId, dishId, dish);
        return ResponseEntity.ok().build();
    }

    /**
     * Delete a dish
     * @param restaurantId the restaurant id
     * @param dishId the dish id
     */
    @DeleteMapping("/{dishId}")
    public ResponseEntity<Void> deleteDish(@PathVariable Long restaurantId,
                                             @PathVariable Long dishId) {
        dishService.deleteDish(restaurantId, dishId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * Get all dishes by restaurant
     * @param restaurantId the restaurant id
     * @return a list of dishes
     */
    @GetMapping
    public ResponseEntity<List<Dish>> getDishesByRestaurant(@PathVariable Long restaurantId) {
        return ResponseEntity.ok(dishService.getDishesByRestaurant(restaurantId));
    }

}
