package com.att.tdp.bisbis10.services;

import com.att.tdp.bisbis10.Constants;
import com.att.tdp.bisbis10.entities.Dish;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.repositories.DishRepository;
import com.att.tdp.bisbis10.repositories.RestaurantRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;

    public void addDish(Long restaurantId, Dish dish) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new EntityNotFoundException(Constants.RESTAURANT_NOT_FOUND + restaurantId));
        dish.setRestaurant(restaurant);
        dishRepository.save(dish);
    }

    public void updateDish(Long restaurantId, Long dishId, Dish dish) {
        Dish existingDish = dishRepository.findByIdAndRestaurantId(dishId, restaurantId)
                .orElseThrow(() -> new EntityNotFoundException(Constants.DISH_NOT_FOUND + dishId));
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
        dishRepository.save(existingDish);
    }

    public void deleteDish(Long restaurantId, Long dishId) {
        Dish existingDish = dishRepository.findByIdAndRestaurantId(dishId, restaurantId)
                .orElseThrow(() -> new EntityNotFoundException(Constants.DISH_NOT_FOUND + dishId));
        dishRepository.delete(existingDish);
    }

    public List<Dish> getDishesByRestaurant(Long restaurantId) {
        return dishRepository.findAllByRestaurantId(restaurantId);
    }

}
