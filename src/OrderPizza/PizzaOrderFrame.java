package OrderPizza;

import BakePizza.OrderHandler;
import Ingredients.Ingredient;
import Pizzas.Pizza;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PizzaOrderFrame extends JFrame {
    private int price = 0;
    private final JPanel pizzaButtons = new JPanel();
    private final JPanel ingredientsButtons = new JPanel();
    private final JPanel centerDisplay = new JPanel();
    private final JLabel priceLabel = new JLabel("Price: " + price);
    private final JButton order = new JButton("Order pizza");
    private final PizzaFactory pizzaFactory = new PizzaFactory();
    private final IngredientFactory ingredientFactory = new IngredientFactory();
    private final ArrayList<Ingredient> chosenIngredients = new ArrayList<>();
    private final OrderHandler orderHandler = OrderHandler.getOrderHandler();
    private boolean pizzaChosen;
    public PizzaOrderFrame(){
        setSize(450, 400);
        setLayout(new BorderLayout());

        initialisePizzaButtons();
        initialiseIngredientsButtons();
        initializeCenterDisplay();
        initializeOrderPizzaButton();

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initializeOrderPizzaButton(){
        order.addActionListener(e -> {
            orderHandler.writeOrderToFile(chosenIngredients);
            chosenIngredients.clear();
            price = 0;
            updateIngredientsAndPriceInCenterDisplay();
            pizzaChosen = false;
            for(Component c: ingredientsButtons.getComponents()){
                c.setForeground(Color.BLACK);
            }
            for(Component c: pizzaButtons.getComponents()){
                c.setForeground(Color.BLACK);
            }
            centerDisplay.remove(order);
            revalidate();
            repaint();
        });
    }

    private void initializeCenterDisplay(){
        centerDisplay.setLayout(new GridLayout(1, 1));
        priceLabel.setVerticalAlignment(SwingConstants.NORTH);
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        centerDisplay.add(priceLabel);
        add(centerDisplay, BorderLayout.CENTER);
    }

    private void initialisePizzaButtons(){
        int counter = 0;
        for(PizzaNames pizzaName: PizzaNames.values()){
            counter++;
            Pizza temp = pizzaFactory.createPizza(pizzaName);
            JButton tempButton = implementPizzaButton(temp);
            pizzaButtons.add(tempButton);
        }
        pizzaButtons.setLayout(new GridLayout(counter, 1));
        add(pizzaButtons, BorderLayout.WEST);
    }

    private JButton implementPizzaButton(Pizza temp) {
        temp.initializeIngredients();
        JButton tempButton = new JButton(temp.getName() + " || " + temp.getPrice() + "kr");
        tempButton.setHorizontalAlignment(SwingConstants.RIGHT);
        tempButton.addActionListener(e -> {
            if(chosenIngredients.containsAll(temp.getIngredients())){
                price -= temp.getPrice();
                for(Ingredient i: temp.getIngredients()){
                    chosenIngredients.remove(i);
                    tempButton.setForeground(Color.BLACK);
                    pizzaChosen = false;
                }
            }else if(!pizzaChosen){
                chosenIngredients.addAll(temp.getIngredients());
                tempButton.setForeground(new Color(24, 190, 27));
                pizzaChosen = true;
                price += temp.getPrice();
            }
            updateIngredientsAndPriceInCenterDisplay();
        });
        return tempButton;
    }

    private void initialiseIngredientsButtons(){
        int counter = 0;
        for(IngredientsNames ingredientName: IngredientsNames.values()){
            if(ingredientName != IngredientsNames.BREAD) {
                counter++;
                Ingredient temp = ingredientFactory.createIngredient(ingredientName);
                JButton tempButton = implementIngredientButtons(temp);
                ingredientsButtons.add(tempButton);
            }
        }
        ingredientsButtons.setLayout(new GridLayout(counter, 1));
        add(ingredientsButtons, BorderLayout.EAST);
    }

    private JButton implementIngredientButtons(Ingredient temp) {
        JButton tempButton = new JButton(temp.getPrice() + "kr" + " || " + temp.getName());
        tempButton.setHorizontalAlignment(SwingConstants.LEFT);
        tempButton.addActionListener(e -> {
            if(pizzaChosen) {
                if (chosenIngredients.contains(temp)) {
                    chosenIngredients.remove(temp);
                    tempButton.setForeground(Color.BLACK);
                    price -= temp.getPrice();
                } else {
                    chosenIngredients.add(temp);
                    tempButton.setForeground(new Color(24, 190, 27));
                    price += temp.getPrice();
                }
                updateIngredientsAndPriceInCenterDisplay();
            }
        });
        return tempButton;
    }

    private void updateIngredientsAndPriceInCenterDisplay(){
        priceLabel.setText("Price: " + price);
        centerDisplay.removeAll();
        centerDisplay.add(priceLabel);
        if(pizzaChosen) {
            centerDisplay.add(order);
        }
        chosenIngredients.sort((ingredient1, ingredient2) ->
                ingredient1.getName().compareToIgnoreCase(ingredient2.getName()));
        for(Ingredient i: chosenIngredients){
            JLabel temp = new JLabel(i.getName());
            temp.setHorizontalAlignment(SwingConstants.CENTER);
            centerDisplay.add(temp);
        }
        centerDisplay.setLayout(new GridLayout(chosenIngredients.size() + 2, 1));
        revalidate();
        repaint();
    }
}
