package BakePizza;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class OrdersWindow extends JFrame {
    private final JTextArea order = new JTextArea();

    public OrdersWindow(Path path, OrderDisplay orderDisplay){
        setLayout(new GridLayout(2,1));
        displayOrder(path);
        JButton completeOrder = new JButton("Order fulfilled");
        completeOrder.addActionListener(e -> {
            orderDisplay.removeOrder(path);
            dispose();});
        add(order);
        add(completeOrder);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void displayOrder(Path path){
        try(BufferedReader br = Files.newBufferedReader(path)){
            String reader;
            while((reader = br.readLine()) != null){
                order.append(reader);
                if(!reader.endsWith("-")){
                    order.append("\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        order.setEditable(false);
    }
}
