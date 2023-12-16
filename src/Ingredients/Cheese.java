package Ingredients;

import Ingredients.Ingredient;

import java.util.ArrayList;

public class Cheese implements Ingredient {

    @Override
    public String getName() {
        return "Cheese";
    }

    @Override
    public int getPrice() {
        return 5;
    }

}
