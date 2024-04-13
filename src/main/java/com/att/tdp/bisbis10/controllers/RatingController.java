package com.att.tdp.bisbis10.controllers;

import com.att.tdp.bisbis10.entities.Rating;
import com.att.tdp.bisbis10.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    /**
     * Add new rating
     * @param rating rating to add
     */
    @PostMapping("")
    public ResponseEntity<Void> addRating(@RequestBody Rating rating) {
        ratingService.addRating(rating);
        return ResponseEntity.ok().build();
    }
}
