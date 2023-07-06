package Esercizi.SpringBoot.Develhope_Spring.controllers;

import Esercizi.SpringBoot.Develhope_Spring.component.ResturantConfig;
import Esercizi.SpringBoot.Develhope_Spring.entities.Ingredient;
import Esercizi.SpringBoot.Develhope_Spring.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/ingredient/")
public class Ex5IngredientController {
    private IngredientService ingredientService;
    private ResturantConfig resturantConfig;
    @Autowired
    public Ex5IngredientController(IngredientService ingredientService, ResturantConfig restur){
        this.ingredientService = ingredientService;
        this.resturantConfig = resturantConfig;
    }
    @PostMapping
    public ResponseEntity<?> createIngredient(@RequestBody Ingredient ingredient){
        ingredientService.createIngredient(ingredient);
        return ResponseEntity.ok().build();
    }
    @GetMapping(value = "{ingredientId}")
    public ResponseEntity<Ingredient> retrieveIngredient(@PathVariable("ingredientId") long ingredientId){
        return ResponseEntity.ok(ingredientService.getIngredient(ingredientId));
    }
    @PutMapping(value = "{ingredientId}")
    public ResponseEntity<?> updateIngredient(@RequestBody Ingredient ingredient, @PathVariable("ingredientId") long ingredientId){
        ingredientService.updateIngredient(ingredient, ingredientId);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping(value = "{ingredientId}")
    public ResponseEntity<?> deleteIngredient(@PathVariable("ingredientId") long ingredientId){
        ingredientService.deleteIngredient(ingredientId);
        return ResponseEntity.ok().build();
    }
}
