package com.att.tdp.bisbis10.services;

import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.repositories.RestaurantRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    private final String NOT_FOUND = "Restaurant not found with ID: ";

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public List<Restaurant> getRestaurantsByCuisine(String cuisine) {
        return restaurantRepository.findByCuisinesContaining(cuisine);
    }

    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    public void updateRestaurant(Long id, Restaurant restaurantDtls) {
        // Check if the restaurant exists
        Restaurant existingRestaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));

        if(restaurantDtls.getName() != null) {
            existingRestaurant.setName(restaurantDtls.getName());
        }
        if(restaurantDtls.isKosher() != null && restaurantDtls.isKosher() != existingRestaurant.isKosher()) {
            existingRestaurant.setIsKosher(restaurantDtls.isKosher());
        }
        if(restaurantDtls.getCuisines() != null) {
            existingRestaurant.setCuisines(restaurantDtls.getCuisines());
        }
        // Save the updated restaurant
        restaurantRepository.save(existingRestaurant);
    }


    public void deleteRestaurant(Long id) {
        // Check if the restaurant exists
        Restaurant existingRestaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
        // Delete the restaurant
        restaurantRepository.delete(existingRestaurant);
    }
}
