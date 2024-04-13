package com.att.tdp.bisbis10.controllers;

import com.att.tdp.bisbis10.entities.Rating;
import com.att.tdp.bisbis10.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    /**
     * Add new rating
     * @param rating rating to add
     * @return added rating
     */
    @PostMapping("")
    public ResponseEntity<Rating> addRestaurant(@RequestBody Rating rating) {
        return ResponseEntity.ok(ratingService.addRating(rating));
    }
}
