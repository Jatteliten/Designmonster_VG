package OrderPizza;

import Ingredients.Bacon;
import Ingredients.Bread;
import Ingredients.Cheese;
import Ingredients.Ham;
import Ingredients.Ingredient;
import Ingredients.Mushroom;
import Ingredients.Onion;
import Ingredients.Pepperoni;
import Ingredients.Shrimp;
import Ingredients.TomatoSauce;
import Ingredients.Tuna;

public class IngredientFactory {
    public Ingredient createIngredient(IngredientsNames ingredient){
        switch(ingredient){
            case BREAD -> {
                return new Bread();
            }
            case TOMATO_SAUCE -> {
                return new TomatoSauce();
            }
            case CHEESE -> {
                return new Cheese();
            }
            case BACON -> {
                return new Bacon();
            }
            case HAM -> {
                return new Ham();
            }
            case TUNA -> {
                return new Tuna();
            }
            case PEPPERONI -> {
                return new Pepperoni();
            }
            case ONION -> {
                return new Onion();
            }
            case SHRIMPS -> {
                return new Shrimp();
            }
            case MUSHROOMS -> {
                return new Mushroom();
            }
            default ->{
                System.err.println("Unknown ingredient: " + ingredient);
                return null;
            }
        }
    }
}
