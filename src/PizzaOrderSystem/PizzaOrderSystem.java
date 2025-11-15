package PizzaOrderSystem;

import javax.swing.*;
public class PizzaOrderSystem extends JFrame {
    private JPanel contentPane;
    private JComboBox sizeBox;
    private JComboBox toppingsBox;
    private JButton calculateButton;
    private JComboBox extraCheeseBox;
    private JLabel sizeLabel;
    private JLabel toppingsLabel;
    private JLabel extraCheeseLabel;
    private JLabel result;

    public PizzaOrderSystem() {
        setTitle("Pizza Ordering System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(contentPane);

        sizeBox.setName("pizzaSizeChoice");
        toppingsBox.setName("pizzaToppingsChoice");
        result.setName("totalLabel");
        calculateButton.setName("calculateButton");
        extraCheeseBox.setName("extraCheeseChoice");

        result.setText("0");

        calculateButton.addActionListener(e -> calculateTotal());
        pack();
        setLocationRelativeTo(null);
    }

    private void calculateTotal() {
        int total = 0;

        String size = (String) sizeBox.getSelectedItem();
        if(size.equals("Small")) {
            total = 10;
        } else if(size.equals("Medium")) {
            total = 15;
        } else if(size.equals("Large")) {
            total = 20;
        }

        total += 2;

        String extraCheese = (String) extraCheeseBox.getSelectedItem();
        if(extraCheese.equals("Yes")) {
            total += 3;
        }

        result.setText(String.valueOf(total));
    }
}
