package Pizzas;

import Ingredients.Ingredient;

import java.util.ArrayList;

public interface Pizza {
    String getName();
    void initializeIngredients();
    ArrayList<Ingredient> getIngredients();
    int getPrice();

}