package Pizzas;

import Ingredients.Bread;
import Ingredients.Cheese;
import Ingredients.TomatoSauce;
import Ingredients.Tuna;

public class AlTono extends DefaultPizza{

    @Override
    public String getName() {
        return "Al tono";
    }

    @Override
    public void initializeIngredients() {
        ingredients.add(new Bread());
        ingredients.add(new Cheese());
        ingredients.add(new TomatoSauce());
        ingredients.add(new Tuna());
    }

}