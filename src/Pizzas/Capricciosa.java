package Pizzas;

import Ingredients.Bread;
import Ingredients.Cheese;
import Ingredients.Ham;
import Ingredients.Mushroom;
import Ingredients.TomatoSauce;

public class Capricciosa extends DefaultPizza {

    @Override
    public String getName() {
        return "Capricciosa";
    }

    @Override
    public void initializeIngredients() {
        ingredients.add(new Bread());
        ingredients.add(new Cheese());
        ingredients.add(new TomatoSauce());
        ingredients.add(new Ham());
        ingredients.add(new Mushroom());
    }

}
