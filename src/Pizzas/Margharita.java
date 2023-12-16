package Pizzas;

import Ingredients.Bread;
import Ingredients.Cheese;
import Ingredients.TomatoSauce;

public class Margharita extends DefaultPizza {

    @Override
    public String getName() {
        return "Margharita";
    }

    @Override
    public void initializeIngredients() {
        ingredients.add(new Bread());
        ingredients.add(new Cheese());
        ingredients.add(new TomatoSauce());
    }

}
