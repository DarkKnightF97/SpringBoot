package Esercizi.SpringBoot.Develhope_Spring.repositories;

import Esercizi.SpringBoot.Develhope_Spring.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientDao extends JpaRepository<Ingredient, Long> {
}
