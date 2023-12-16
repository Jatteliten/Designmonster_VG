package Pizzas;

import Ingredients.Bacon;
import Ingredients.Bread;
import Ingredients.Cheese;
import Ingredients.Pepperoni;
import Ingredients.TomatoSauce;

public class Paesana extends DefaultPizza{

    @Override
    public String getName() {
        return "Paesana";
    }

    @Override
    public void initializeIngredients() {
        ingredients.add(new Bread());
        ingredients.add(new Cheese());
        ingredients.add(new TomatoSauce());
        ingredients.add(new Bacon());
        ingredients.add(new Pepperoni());
    }

}
