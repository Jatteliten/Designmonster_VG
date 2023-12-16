package Ingredients;

public class Pepperoni implements Ingredient{
    @Override
    public String getName() {
        return "Pepperoni";
    }

    @Override
    public int getPrice() {
        return 10;
    }
}
