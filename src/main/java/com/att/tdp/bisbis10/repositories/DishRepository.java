package com.att.tdp.bisbis10.repositories;

import com.att.tdp.bisbis10.entities.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
    Optional<Dish> findByIdAndRestaurantId(Long dishId, Long restaurantId);
    List<Dish> findAllByRestaurantId(Long restaurantId);
}