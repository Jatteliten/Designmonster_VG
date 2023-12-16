package Pizzas;

import Ingredients.Bread;
import Ingredients.Cheese;
import Ingredients.Ham;
import Ingredients.TomatoSauce;
import Ingredients.Tuna;

public class Opera extends DefaultPizza{

    @Override
    public String getName() {
        return "Opera";
    }


    @Override
    public void initializeIngredients() {
        ingredients.add(new Bread());
        ingredients.add(new Cheese());
        ingredients.add(new TomatoSauce());
        ingredients.add(new Ham());
        ingredients.add(new Tuna());
    }

}
