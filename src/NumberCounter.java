import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberCounter extends JFrame {
    private JLabel countLabel;
    private JButton increaseButton;
    private JButton decreaseButton;
    private int count = 0;
    
    public NumberCounter() {
        setTitle("Number Counter");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        
        // Create and configure label
        countLabel = new JLabel("0");
        countLabel.setName("countLabel");
        countLabel.setFont(new Font("Arial", Font.BOLD, 24));
        
        // Create and configure increase button
        increaseButton = new JButton("Increase");
        increaseButton.setName("increaseButton");
        increaseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                count++;
                countLabel.setText(String.valueOf(count));
            }
        });
        
        // Create and configure decrease button
        decreaseButton = new JButton("Decrease");
        decreaseButton.setName("decreaseButton");
        decreaseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                count--;
                countLabel.setText(String.valueOf(count));
            }
        });
        
        // Add components to frame
        add(countLabel);
        add(increaseButton);
        add(decreaseButton);
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NumberCounter();
            }
        });
    }
}