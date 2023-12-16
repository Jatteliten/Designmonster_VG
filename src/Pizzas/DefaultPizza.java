package Pizzas;

import Ingredients.Bread;
import Ingredients.Ingredient;

import java.util.ArrayList;

public abstract class DefaultPizza implements Pizza {
    protected final ArrayList<Ingredient> ingredients = new ArrayList<>();

    public String getName(){
        return "Custom pizza";
    }

    @Override
    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }
    @Override
    public void initializeIngredients() {
        ingredients.add(new Bread());
    }

    @Override
    public int getPrice() {
        int price = 0;
        for (Ingredient i : ingredients) {
            price += i.getPrice();
        }
        return price;
    }
}
