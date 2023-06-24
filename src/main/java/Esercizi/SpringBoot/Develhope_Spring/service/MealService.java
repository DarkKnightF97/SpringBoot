package Esercizi.SpringBoot.Develhope_Spring.service;

import Esercizi.SpringBoot.Develhope_Spring.entities.Meal;
import Esercizi.SpringBoot.Develhope_Spring.repositories.MealDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    private MealDao mealDao;
    @Autowired
    public MealService(MealDao mealDao){
        this.mealDao = mealDao;
    }
    public void addMeal(Meal meal){
        if (meal == null) throw new IllegalArgumentException("Meal must not be null");
        if(meal.getName() == null || meal.getName().isEmpty()) throw new IllegalArgumentException("Meal name cannot be null or empty");
        if(meal.getDescription() == null ||meal.getDescription().isEmpty()) throw new IllegalArgumentException("Meal description");
        if(meal.getPrice() <= 0) throw new IllegalArgumentException("Meal price cannot be less than or equal to 0!");
        if(meal.getPrice() > 100) throw new IllegalArgumentException("Meal price cannot be greater than 100!");
        mealDao.addMeal(meal);
    }
    public void deleteMeal(String mealName){
        mealDao.deleteMeal(mealName);
    }
    public void updateMeal(Meal meal){
        mealDao.updateMeal(meal);

    }
    public List<Meal> getMealList(){
        return mealDao.getMealList();
    }
}
