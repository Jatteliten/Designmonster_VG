package BakePizza;

import Ingredients.Ingredient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OrderHandler {
    private static OrderHandler orderHandler;
    private final Path orderNumber = Paths.get("src/BakePizza/Current order number.txt");
    private final List<OrderObserver> observers = new ArrayList<>();
    private OrderHandler(){}

    public void registerObserver(OrderObserver observer){
        observers.add(observer);
    }
    public void notifyObservers(){
        for(OrderObserver observer: observers){
            observer.refreshOrderList();
        }
    }
    public static OrderHandler getOrderHandler(){
        if(orderHandler == null){
            orderHandler = new OrderHandler();
        }
        return orderHandler;
    }

    public void writeOrderToFile(ArrayList<Ingredient> ingredients){
        int tempOrdernumber;
        try(BufferedReader br = Files.newBufferedReader(orderNumber)){
            tempOrdernumber = Integer.parseInt(br.readLine());
            tempOrdernumber++;
            BufferedWriter wr = Files.newBufferedWriter(orderNumber);
            wr.write(String.valueOf(tempOrdernumber));
            wr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String fileName = String.valueOf(tempOrdernumber);

        Path newOrderFilePath = Paths.get("src/BakePizza/Orders/" + fileName);
        int price = 0;
        try(BufferedWriter wr = Files.newBufferedWriter(newOrderFilePath)){
            for(Ingredient i: ingredients){
                price += i.getPrice();
                wr.write(i.getName() + "\n");
            }
            wr.write(price + ":-\n");
            wr.write("Order number: " + tempOrdernumber);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        notifyObservers();

    }
}
