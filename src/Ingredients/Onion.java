package Ingredients;

public class Onion implements Ingredient{
    @Override
    public String getName() {
        return "Onion";
    }

    @Override
    public int getPrice() {
        return 2;
    }
}
