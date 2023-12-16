package BakePizza;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class OrderDisplay extends JFrame implements OrderObserver{

    private final File folder = new File("src/BakePizza/Orders");
    private final JPanel orderPanel = new JPanel();
    private final OrderHandler orderHandler = OrderHandler.getOrderHandler();

    public OrderDisplay(){
        setSize(500,500);
        addOrders();
        add(orderPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        orderHandler.registerObserver(this);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void addOrders(){
        File[] files = folder.listFiles();

        if(files != null){
            for(File file: files){
                if(file.isFile()) {
                    JButton temp = new JButton(file.getName());
                    temp.addActionListener(e -> new OrdersWindow(Path.of(file.getPath()), this));
                    orderPanel.add(temp);
                }
            }
        }
    }

    public void removeOrder(Path path){
        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        orderHandler.notifyObservers();
    }

    @Override
    public void refreshOrderList(){
        orderPanel.removeAll();
        addOrders();
        revalidate();
        repaint();
    }

}
