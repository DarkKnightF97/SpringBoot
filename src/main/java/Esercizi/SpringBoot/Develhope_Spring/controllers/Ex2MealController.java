package Esercizi.SpringBoot.Develhope_Spring.controllers;

import Esercizi.SpringBoot.Develhope_Spring.entities.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController

public class Ex2MealController {
    private List<Meal> mealList = new ArrayList<>(Arrays.asList(
            new Meal("Pasta al pesto","pasta con pesto di basilico fresco", 10),
            new Meal("Carbonara","pasta tradizionale con uovo, pecorino e guanciale", 15),
            new Meal("Pasta con le zucchine","pasta con zucchine fritte", 9),
            new Meal("Pasta al sugo","pasta con sugo di pomodoro", 5)
    ));
    @GetMapping("/meal")
    public ResponseEntity<List> mealResponse(){
        return ResponseEntity.ok(mealList);
    }







}
