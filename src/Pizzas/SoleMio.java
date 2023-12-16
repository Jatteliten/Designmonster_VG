package Pizzas;

import Ingredients.Bread;
import Ingredients.Cheese;
import Ingredients.Ham;
import Ingredients.Pepperoni;
import Ingredients.TomatoSauce;

public class SoleMio extends DefaultPizza{

    @Override
    public String getName() {
        return "Sole Mio";
    }

    @Override
    public void initializeIngredients() {
        ingredients.add(new Bread());
        ingredients.add(new Cheese());
        ingredients.add(new TomatoSauce());
        ingredients.add(new Ham());
        ingredients.add(new Pepperoni());
    }

}
