package Esercizi.SpringBoot.Develhope_Spring.repositories;

import Esercizi.SpringBoot.Develhope_Spring.entities.Meal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealDao extends JpaRepository<Meal, Long> {
    List<Meal> findByIsWinterMeal(boolean isWinterMeal);
}
