package Esercizi.SpringBoot.Develhope_Spring.controllers;

import Esercizi.SpringBoot.Develhope_Spring.entities.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class Ex2MealNameController {
    private List<Meal> mealList = new ArrayList<>(Arrays.asList(
            new Meal("Pasta al pesto","pasta con pesto di basilico fresco", 10, true),
            new Meal("Carbonara","pasta tradizionale con uovo, pecorino e guanciale", 15,true),
            new Meal("Pasta con le zucchine","pasta con zucchine fritte", 9, true),
            new Meal("Pasta al sugo","pasta con sugo di pomodoro", 5, true)
    ));
    @GetMapping("/meal/{name}")
    public ResponseEntity<String> mealNameResponse(
            @PathVariable("name") String name){
        for(Meal meal : mealList){
            if(meal.getName().equalsIgnoreCase(name)){
                return ResponseEntity.ok(meal.getName());
            }
        }
        return ResponseEntity.notFound().build();
    }
}
