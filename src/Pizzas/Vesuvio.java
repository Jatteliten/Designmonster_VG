package Pizzas;

import Ingredients.Bread;
import Ingredients.Cheese;
import Ingredients.Ham;
import Ingredients.TomatoSauce;

public class Vesuvio extends DefaultPizza {

    @Override
    public String getName() {
        return "Vesuvio";
    }

    @Override
    public void initializeIngredients() {
        ingredients.add(new Bread());
        ingredients.add(new Cheese());
        ingredients.add(new TomatoSauce());
        ingredients.add(new Ham());
    }

}
