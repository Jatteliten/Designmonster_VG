package Ingredients;

public class Ham implements Ingredient{
    @Override
    public String getName() {
        return "Ham";
    }

    @Override
    public int getPrice() {
        return 10;
    }
}
