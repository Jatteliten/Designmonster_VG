package Pizzas;

import Ingredients.Bread;
import Ingredients.Cheese;
import Ingredients.Mushroom;
import Ingredients.TomatoSauce;

public class Funghi extends DefaultPizza{

    @Override
    public String getName() {
        return "Funghi";
    }

    @Override
    public void initializeIngredients() {
        ingredients.add(new Bread());
        ingredients.add(new Cheese());
        ingredients.add(new TomatoSauce());
        ingredients.add(new Mushroom());
    }

}
