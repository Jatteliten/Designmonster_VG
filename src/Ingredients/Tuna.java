package Ingredients;

public class Tuna implements Ingredient{
    @Override
    public String getName() {
        return "Tuna";
    }

    @Override
    public int getPrice() {
        return 10;
    }
}
