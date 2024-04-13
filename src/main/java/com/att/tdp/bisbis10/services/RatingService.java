package com.att.tdp.bisbis10.services;

import com.att.tdp.bisbis10.entities.Rating;
import com.att.tdp.bisbis10.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }

}
