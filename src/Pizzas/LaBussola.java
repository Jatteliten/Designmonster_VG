package Pizzas;

import Ingredients.Bread;
import Ingredients.Cheese;
import Ingredients.Ham;
import Ingredients.Shrimp;
import Ingredients.TomatoSauce;

public class LaBussola extends DefaultPizza {
    @Override
    public String getName() {
        return "La Bussola";
    }

    @Override
    public void initializeIngredients() {
        ingredients.add(new Bread());
        ingredients.add(new Cheese());
        ingredients.add(new TomatoSauce());
        ingredients.add(new Ham());
        ingredients.add(new Shrimp());
    }

}
