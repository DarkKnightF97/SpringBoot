package Esercizi.SpringBoot.Develhope_Spring.repositories;

import Esercizi.SpringBoot.Develhope_Spring.entities.Meal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class MealDao {
    private List<Meal> mealList = new ArrayList<>(Arrays.asList(
            new Meal("Pasta al pesto","pasta con pesto di basilico fresco", 10),
            new Meal("Carbonara","pasta tradizionale con uovo, pecorino e guanciale", 15),
            new Meal("Pasta con le zucchine","pasta con zucchine fritte", 9),
            new Meal("Pasta al sugo","pasta con sugo di pomodoro", 5)
    ));
    public void addMeal(Meal meal){
        this.mealList.add(meal);
    }
    public void deleteMeal(String mealName){
        this.mealList.removeIf(meal -> meal.getName().equals(mealName));
    }
    public void updateMeal(Meal meal){
        this.mealList.removeIf(m -> m.getName().equals(meal.getName()));
        this.mealList.add(meal);
    }
    public List<Meal> getMealList(){
        return this.mealList;
    }
}
