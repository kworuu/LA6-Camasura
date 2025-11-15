import java.awt.*;
import java.awt.event.*;

public class PizzaOrderSystem extends Frame {
    private Choice pizzaSizeChoice;
    private Choice pizzaToppingsChoice;
    private Choice extraCheeseChoice;
    private Label totalLabel;
    private Button calculateButton;
    
    public PizzaOrderSystem() {
        setTitle("Pizza Order System");
        setSize(400, 250);
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 15));
        
        // Create and configure pizza size choice
        Label sizeLabel = new Label("Pizza Size:");
        pizzaSizeChoice = new Choice();
        pizzaSizeChoice.setName("pizzaSizeChoice");
        pizzaSizeChoice.add("Small");
        pizzaSizeChoice.add("Medium");
        pizzaSizeChoice.add("Large");
        
        // Create and configure pizza toppings choice
        Label toppingsLabel = new Label("Toppings:");
        pizzaToppingsChoice = new Choice();
        pizzaToppingsChoice.setName("pizzaToppingsChoice");
        pizzaToppingsChoice.add("Mushrooms");
        pizzaToppingsChoice.add("Pepperoni");
        pizzaToppingsChoice.add("Onions");
        
        // Create and configure extra cheese choice
        Label cheeseLabel = new Label("Extra Cheese:");
        extraCheeseChoice = new Choice();
        extraCheeseChoice.setName("extraCheeseChoice");
        extraCheeseChoice.add("Yes");
        extraCheeseChoice.add("No");
        
        // Create and configure total label
        totalLabel = new Label("Total: $0");
        totalLabel.setName("totalLabel");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 14));
        
        // Create and configure calculate button
        calculateButton = new Button("Calculate Total");
        calculateButton.setName("calculateButton");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateTotal();
            }
        });
        
        // Add components to frame
        add(sizeLabel);
        add(pizzaSizeChoice);
        add(toppingsLabel);
        add(pizzaToppingsChoice);
        add(cheeseLabel);
        add(extraCheeseChoice);
        add(calculateButton);
        add(totalLabel);
        
        // Window closing event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        setVisible(true);
    }
    
    private void calculateTotal() {
        int total = 0;
        
        // Calculate base price based on size
        String size = pizzaSizeChoice.getSelectedItem();
        if (size.equals("Small")) {
            total = 10;
        } else if (size.equals("Medium")) {
            total = 15;
        } else if (size.equals("Large")) {
            total = 20;
        }
        
        // Add topping price
        total += 2;
        
        // Add extra cheese if selected
        String extraCheese = extraCheeseChoice.getSelectedItem();
        if (extraCheese.equals("Yes")) {
            total += 3;
        }
        
        // Update total label
        totalLabel.setText("Total: $" + total);
    }
    
    public static void main(String[] args) {
        new PizzaOrderSystem();
    }
}