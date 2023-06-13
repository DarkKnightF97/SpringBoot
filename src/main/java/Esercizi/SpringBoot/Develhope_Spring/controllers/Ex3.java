package Esercizi.SpringBoot.Develhope_Spring.controllers;

import Esercizi.SpringBoot.Develhope_Spring.entities.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RestController
public class Ex3 {
    private List<Meal> mealList = new ArrayList<>(Arrays.asList(
            new Meal("Pasta al pesto","pasta con pesto di basilico fresco", 10),
            new Meal("Carbonara","pasta tradizionale con uovo, pecorino e guanciale", 15),
            new Meal("Pasta con le zucchine","pasta con zucchine fritte", 9),
            new Meal("Pasta al sugo","pasta con sugo di pomodoro", 5)
    ));
    @PutMapping(value = "/meal")
    public ResponseEntity<String> putMeal(@RequestBody Meal meal){
        this.mealList.add(meal);
        return ResponseEntity.ok("Pasto aggiunto");
    }
    @GetMapping(value = "/meals")
    public ResponseEntity<List<Meal>> getMeal(){
        return ResponseEntity.ok(mealList);
    }
    @PostMapping(value = "/meal/{name}")
    public ResponseEntity<String> updateMealName(
            @PathVariable String name,@RequestBody Meal mealUpdate){
        for(Meal meal : mealList){
            if(meal.getName().equals(name)){
                meal.setName(mealUpdate.getName());
                return ResponseEntity.ok("Pasto aggiornato");
            }

        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping(value = "/meal/{name}")
    public ResponseEntity<String> deleteMeal(
            @PathVariable String name){
        for(Meal meal : mealList){
            if(meal.getName().equals(name)){
                mealList.remove(meal);
                return ResponseEntity.ok("Pasto eliminato");
            }
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping(value = "/meal/price/{price}")
    public ResponseEntity<String> deleteMealPrice(
            @PathVariable Double price){
        List<Meal> mealToRemove = new ArrayList<>();
        for(Meal meal : mealList){
            if(meal.getPrice() > price){
                mealToRemove.add(meal);
            }
        }
        mealList.removeAll(mealToRemove);
        if(!mealToRemove.isEmpty()){
            return ResponseEntity.ok("Pasti eliminati");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping(value = "/meal/{name}/price")
    public ResponseEntity<String> deleteMealByPrice(
            @PathVariable String name,@RequestBody Meal updatePrice
    ){
        for(Meal meal : mealList){
            if(meal.getName().equals(name)){
                meal.setPrice(updatePrice.getPrice());
                return ResponseEntity.ok("Pasto aggiornato");
            }
        }
        return ResponseEntity.notFound().build();
    }
    


}
