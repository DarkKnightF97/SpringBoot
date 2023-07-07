package Esercizi.SpringBoot.Develhope_Spring.service;

import Esercizi.SpringBoot.Develhope_Spring.component.ResturantConfig;
import Esercizi.SpringBoot.Develhope_Spring.entities.Ingredient;
import Esercizi.SpringBoot.Develhope_Spring.entities.Meal;
import Esercizi.SpringBoot.Develhope_Spring.repositories.MealDao;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MealService {
    private MealDao mealDao;
    private ResturantConfig resturantConfig;
    private double MIN_WINTER_TEMP = 6.0;

    @Autowired
    public MealService(MealDao mealDao, ResturantConfig resturantConfig) {
        this.mealDao = mealDao;
        this.resturantConfig = resturantConfig;
    }

    public void createMeal(Meal meal) {
        mealDao.save(meal);
    }

    public Meal getMeal(long mealId) {
        return mealDao.findById(mealId).orElse(null);
    }

    public void updateMeal(Meal meal, long mealId) {
        mealDao.deleteById(mealId);
        mealDao.save(meal);
    }

    public void deleteMeal(long mealId) {
        mealDao.deleteById(mealId);
    }

    public List<Meal> getWinterMeal() {
        getCurrentTemperatureInCentigrade();
        if (getCurrentTemperatureInCentigrade() < MIN_WINTER_TEMP) return new ArrayList<>();
        return mealDao.findByIsWinterMeal(true);
    }

    private Double getCurrentTemperatureInCentigrade() {
        try {
            JSONObject response = Unirest.get("https://api.open-meteo.com/v1/forecast?latitude=38.132&longitude=13.3356&current_weather=true")
                    .asJson().getBody().getObject();
            return response.getJSONObject("current_weather").getDouble("temperature");
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    /*public void addMeal(Meal meal){
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
    }*/
    }
}