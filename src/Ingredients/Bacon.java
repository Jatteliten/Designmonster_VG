package Ingredients;

public class Bacon implements Ingredient{
    @Override
    public String getName() {
        return "Bacon";
    }

    @Override
    public int getPrice() {
        return 10;
    }
}
