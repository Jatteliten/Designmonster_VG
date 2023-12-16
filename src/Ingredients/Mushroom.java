package Ingredients;

public class Mushroom implements Ingredient{
    @Override
    public String getName() {
        return "Mushrooms";
    }

    @Override
    public int getPrice() {
        return 5;
    }
}
