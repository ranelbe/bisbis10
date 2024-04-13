package com.att.tdp.bisbis10.repositories;

import com.att.tdp.bisbis10.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    Long countByRestaurantId(Long restaurantId);
//    @Query("SELECT AVG(r.rating) FROM Rating r WHERE r.restaurantId = ?1")
//    Double findAverageRatingByRestaurantId(Long restaurantId);
}