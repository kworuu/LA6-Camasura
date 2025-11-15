package NumberCounter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberCounter extends JFrame {
    private JPanel contentPane;
    private JLabel countLabel;
    private JButton decreaseButton;
    private JButton increaseButton;
    private int count = 0;

    public NumberCounter (){
        setTitle("Number Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        pack();

        setLocationRelativeTo(null);
        countLabel.setText(String.valueOf(count));

        increaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                increaseNum();
            }
        });

        decreaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decreaseNum();
            }
        });

        setVisible(true);
    }

    public void increaseNum(){
        count++;
        countLabel.setText(String.valueOf(count));
    }

    public void decreaseNum(){
        count--;
        countLabel.setText(String.valueOf(count));
    }

}
