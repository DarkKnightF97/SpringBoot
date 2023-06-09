package Esercizi.SpringBoot.Develhope_Spring.controllers;

import Esercizi.SpringBoot.Develhope_Spring.component.ResturantConfig;
import Esercizi.SpringBoot.Develhope_Spring.entities.Ingredient;
import Esercizi.SpringBoot.Develhope_Spring.entities.Meal;
import Esercizi.SpringBoot.Develhope_Spring.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Ex3MealController {
    /**
     * private List<Meal> mealList = new ArrayList<>(Arrays.asList(
     *             new Meal("Pasta al pesto","pasta con pesto di basilico fresco", 10),
     *             new Meal("Carbonara","pasta tradizionale con uovo, pecorino e guanciale", 15),
     *             new Meal("Pasta con le zucchine","pasta con zucchine fritte", 9),
     *             new Meal("Pasta al sugo","pasta con sugo di pomodoro", 5)
     *     ));
     */
    private MealService mealService;
    private ResturantConfig resturantConfig;
    @Autowired
    public Ex3MealController(MealService mealService, ResturantConfig resturantConfig) {
        this.mealService = mealService;
        this.resturantConfig = resturantConfig;
    }
    @PostMapping
    public ResponseEntity<?> createMeal(@RequestBody Meal meal){
        mealService.createMeal(meal);
        return ResponseEntity.ok().build();
    }
    @GetMapping(value = "{mealId}")
    public ResponseEntity<Meal> retrieveMeal(@PathVariable("mealId") long mealId){
        return ResponseEntity.ok(mealService.getMeal(mealId));
    }
    @PutMapping(value = "{mealId}")
    public ResponseEntity<?> updateMeal(@RequestBody Meal meal, @PathVariable("mealId") long mealId){
        mealService.updateMeal(meal, mealId);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping(value = "{mealId}")
    public ResponseEntity<?> deleteMeal(@PathVariable("mealId") long mealId){
        mealService.deleteMeal(mealId);
        return ResponseEntity.ok().build();
    }
    @GetMapping(value = "/winter-meals")
    public ResponseEntity<List<Meal>> getWinterMeals(){
        return ResponseEntity.ok(mealService.getWinterMeal());
    }
   /* @GetMapping(value = "/resturant-config")
    public ResponseEntity<ResturantConfig> getResturantConfig() {
        this.resturantConfig.setLocalePieno(true);
        this.resturantConfig.setMaxPrice(50.00);
        return ResponseEntity.ok(resturantConfig);
    }
    @PutMapping(value = "/meal")
    public ResponseEntity<String> putMeal(@RequestBody Meal meal){
        mealService.addMeal(meal);
        return ResponseEntity.ok("Pasto aggiunto");
    }
    @GetMapping(value = "/meals")
    public ResponseEntity<List<Meal>> getMeal(){
        return ResponseEntity.ok(mealService.getMealList());
    }

    @DeleteMapping(value = "/meal/{name}")
    public ResponseEntity<String> deleteMeal(@PathVariable String name){
            mealService.deleteMeal(name);
            return ResponseEntity.ok("Pasto eliminato");
    }


    @PostMapping(value = "/meal/{name}")
    public ResponseEntity<String> updateMealName(
            @PathVariable String name,@RequestBody Meal mealUpdate){
        List<Meal> mealList = mealService.getMealList();
        for(Meal meal : mealList){
            if(meal.getName().equals(name)){
                mealUpdate.setName(mealUpdate.getName());
                mealService.updateMeal(meal);
                return ResponseEntity.ok("Pasto aggiornato");
            }

        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping(value = "/meal/price/{price}")
    public ResponseEntity<String> deleteMealPrice(@PathVariable Double price){
        List<Meal> mealList = mealService.getMealList();
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
   /* @PostMapping(value = "/meal/{name}/price")
    public ResponseEntity<String> deleteMealByPrice(
            @PathVariable String name,@RequestBody Meal updatePrice
    ){
        List<Meal> mealList = mealService.getMealList();
        for(Meal meal : mealList){
            if(meal.getName().equals(name)){
                meal.setPrice(updatePrice.getPrice());
                return ResponseEntity.ok("Pasto aggiornato");
            }
        }
        return ResponseEntity.notFound().build();
    }*/
    


}
