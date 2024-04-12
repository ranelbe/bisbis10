package com.att.tdp.bisbis10.controllers;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.services.RestaurantService;
import jakarta.persistence.EntityNotFoundException;
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
     * @param cuisine cuisine to filter by
     * @return list of restaurants
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
     * @return restaurant
     * @throws EntityNotFoundException if restaurant not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(restaurantService.getRestaurantById(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    /**
     * Add new restaurant
     * @param restaurant restaurant to add
     * @return added restaurant
     */
    @PostMapping("")
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {
        return new ResponseEntity<>(restaurantService.addRestaurant(restaurant), HttpStatus.CREATED);
    }

    /**
     * Update restaurant
     * @param id id of restaurant
     * @param restaurantDtls updated restaurant details
     * @return updated restaurant
     * @throws EntityNotFoundException if restaurant not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id,
                                                       @RequestBody Restaurant restaurantDtls) {
        try {
            return ResponseEntity.ok(restaurantService.updateRestaurant(id, restaurantDtls));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    /**
     * Delete restaurant
     * @param id id of restaurant
     * @return deleted restaurant
     * @throws EntityNotFoundException if restaurant not found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(restaurantService.deleteRestaurant(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

}
