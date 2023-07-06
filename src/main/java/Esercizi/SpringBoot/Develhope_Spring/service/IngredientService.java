package Esercizi.SpringBoot.Develhope_Spring.service;

import Esercizi.SpringBoot.Develhope_Spring.component.ResturantConfig;
import Esercizi.SpringBoot.Develhope_Spring.entities.Ingredient;
import Esercizi.SpringBoot.Develhope_Spring.repositories.IngredientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {
    private IngredientDao ingredientDao;
    private ResturantConfig resturantConfig;
    @Autowired
    public IngredientService(IngredientDao ingredientDao, ResturantConfig resturantConfig) {
        this .ingredientDao = ingredientDao;
        this .resturantConfig = resturantConfig;
    }
    public void createIngredient(Ingredient ingredient){
        ingredientDao.save(ingredient);
    }
    public Ingredient getIngredient(long ingredientId){
       return ingredientDao.findById(ingredientId).orElse(null);
    }
    public void updateIngredient(Ingredient ingredient, long ingredientId){
        ingredientDao.deleteById(ingredientId);
        ingredientDao.save(ingredient);
    }
    public void deleteIngredient(long ingredientId){
         ingredientDao.deleteById(ingredientId);
    }
}
