package Ingredients;

public class TomatoSauce implements Ingredient{
    @Override
    public String getName() {
        return "Tomato sauce";
    }

    @Override
    public int getPrice() {
        return 10;
    }
}
