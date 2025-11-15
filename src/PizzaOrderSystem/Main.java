package PizzaOrderSystem;

import NumberCounter.NumberCounter;

import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PizzaOrderSystem pizzaOrderSystem = new PizzaOrderSystem();
                pizzaOrderSystem.setVisible(true);
            }
        });
    }
}