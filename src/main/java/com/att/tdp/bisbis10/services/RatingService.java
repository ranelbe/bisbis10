package com.att.tdp.bisbis10.services;

import com.att.tdp.bisbis10.entities.Rating;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.repositories.RatingRepository;
import com.att.tdp.bisbis10.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;

    public void addRating(Rating rating) {
        Long restaurantId = rating.getRestaurantId();
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);
        Long countRestaurantRating = ratingRepository.countByRestaurantId(restaurantId);
        if (restaurant != null) {
            ratingRepository.save(rating);
            restaurant.setRating((restaurant.getRating() * countRestaurantRating
                    + rating.getRating()) / (countRestaurantRating + 1));
            restaurantRepository.save(restaurant);
        }
    }
}
