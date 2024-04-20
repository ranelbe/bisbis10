package com.att.tdp.bisbis10.services;

import com.att.tdp.bisbis10.Constants;
import com.att.tdp.bisbis10.entities.Rating;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.repositories.RatingRepository;
import com.att.tdp.bisbis10.repositories.RestaurantRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public void addRating(Rating rating) {

        ratingRepository.save(rating);
        Long restaurantId = rating.getRestaurantId();
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                () -> new EntityNotFoundException(Constants.RESTAURANT_NOT_FOUND + restaurantId));

        // Calculate new rating
        int ratingsAmount = restaurant.getRatingsAmount();
        double currentRating = restaurant.getRating();

        // Calculate the new average rating
        double newRating = ((currentRating * ratingsAmount) + rating.getRating()) / (ratingsAmount + 1);

        restaurant.setRating(newRating);
        restaurant.setRatingsAmount(ratingsAmount + 1);

        restaurantRepository.save(restaurant);
    }
}
