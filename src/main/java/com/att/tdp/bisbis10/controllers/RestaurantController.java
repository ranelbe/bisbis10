package com.att.tdp.bisbis10.controllers;

import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    /**
     * Get all restaurants or get restaurants by cuisine
     * @param cuisine cuisine to filter by (optional)
     * @return list of restaurants (empty list if no restaurants found)
     */
    @GetMapping("")
    public ResponseEntity<List<Restaurant>> getRestaurants(@RequestParam(required = false) String cuisine) {
        if (cuisine == null) {
            return ResponseEntity.ok(restaurantService.getAllRestaurants());
        }
        return ResponseEntity.ok(restaurantService.getRestaurantsByCuisine(cuisine));
    }

    /**
     * Get restaurant by id
     * @param id id of restaurant
     * @return restaurant with the given id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id) {
        return ResponseEntity.ok(restaurantService.getRestaurantById(id));
    }

    /**
     * Add new restaurant
     * @param restaurant restaurant to add
     */
    @PostMapping("")
    public ResponseEntity<Void> addRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.addRestaurant(restaurant);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Update restaurant
     * @param id id of the restaurant
     * @param restaurantDtls updated restaurant details
     */
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRestaurant(@PathVariable Long id,
                                                 @RequestBody Restaurant restaurantDtls) {
        restaurantService.updateRestaurant(id, restaurantDtls);
        return ResponseEntity.ok().build();
    }

    /**
     * Delete restaurant
     * @param id id of the restaurant
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }
}
