package com.att.tdp.bisbis10.services;

import com.att.tdp.bisbis10.entities.Dish;
import com.att.tdp.bisbis10.repositories.DishRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;

    private final String NOT_FOUND = "Dish not found with ID: ";

    public List<Dish> getDishesByRestaurant(Long restaurantId) {
        return dishRepository.findAllByRestaurantId(restaurantId);
    }

    public Dish addDish(Long restaurantId, Dish dish) {
        dish.setRestaurantId(restaurantId);
        return dishRepository.save(dish);
    }

    public Dish updateDish(Long restaurantId, Long dishId, Dish dish) {
        Dish existingDish = dishRepository.findByIdAndRestaurantId(dishId, restaurantId)
                .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + dishId));
        if(dish.getName() != null) {
            existingDish.setName(dish.getName());
        }
        if(dish.getPrice() != null) {
            existingDish.setPrice(dish.getPrice());
        }
        if(dish.getDescription() != null) {
            existingDish.setDescription(dish.getDescription());
        }
        // Save the updated dish
        return dishRepository.save(existingDish);
    }

    public String deleteDish(Long restaurantId, Long dishId) {
        Dish existingDish = dishRepository.findByIdAndRestaurantId(dishId, restaurantId)
                .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + dishId));
        dishRepository.delete(existingDish);
        return "Dish deleted with ID: " + dishId;
    }

}
