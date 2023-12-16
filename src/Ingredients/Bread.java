package Ingredients;

public class Bread implements Ingredient{

    @Override
    public String getName() {
        return "Bread";
    }

    @Override
    public int getPrice() {
        return 50;
    }
}
