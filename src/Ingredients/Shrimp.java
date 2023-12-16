package Ingredients;

public class Shrimp implements Ingredient{
    @Override
    public String getName() {
        return "Shrimps";
    }

    @Override
    public int getPrice() {
        return 10;
    }
}
