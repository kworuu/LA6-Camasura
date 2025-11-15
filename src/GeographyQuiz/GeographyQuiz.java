package GeographyQuiz;

import javax.swing.*;
import java.awt.*;

public class GeographyQuiz extends JFrame {
    private JPanel contentPane;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JTextField question1TextField;
    private JTextField question2TextField;
    private JTextField question3TextField;
    private JLabel scoreLabel;
    private JButton nextButton;
    private JButton backButton;
    private JLabel questionLabel;
    private JLabel congratsLabel;

    private CardLayout cardLayout;
    private int score = 0;
    private int currentPanel = 1;

    public GeographyQuiz() {
        setTitle("Geography Quiz");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(contentPane);

        // Set component names
        panel1.setName("panel1");
        panel2.setName("panel2");
        panel3.setName("panel3");
        panel4.setName("panel4");
        question1TextField.setName("question1TextField");
        question2TextField.setName("question2TextField");
        question3TextField.setName("question3TextField");
        scoreLabel.setName("scoreLabel");
        nextButton.setName("nextButton");
        backButton.setName("backButton");

        // Initialize
        scoreLabel.setText("Your Score: 0/3");
        updateButtonVisibility();

        // Add button listeners
        nextButton.addActionListener(e -> goNext());
        backButton.addActionListener(e -> goBack());

        pack();
        setLocationRelativeTo(null);
    }

    private void goNext() {
        if (currentPanel == 1) {
            checkAnswer1();
            showPanel2();
        } else if (currentPanel == 2) {
            checkAnswer2();
            showPanel3();
        } else if (currentPanel == 3) {
            checkAnswer3();
            showPanel4();
        }
        currentPanel++;
        updateButtonVisibility();
    }

    private void goBack() {
        if (currentPanel == 2) {
            showPanel1();
        } else if (currentPanel == 3) {
            showPanel2();
        } else if (currentPanel == 4) {
            showPanel3();
        }
        currentPanel--;
        updateButtonVisibility();
    }

    private void showPanel1() {
        panel1.setVisible(true);
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(false);
    }

    private void showPanel2() {
        panel1.setVisible(false);
        panel2.setVisible(true);
        panel3.setVisible(false);
        panel4.setVisible(false);
    }

    private void showPanel3() {
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(true);
        panel4.setVisible(false);
    }

    private void showPanel4() {
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(true);
    }

    private void updateButtonVisibility() {
        // Back button: visible except on Panel 1
        backButton.setVisible(currentPanel != 1);

        // Next button: visible except on Panel 4
        nextButton.setVisible(currentPanel != 4);
    }

    private void checkAnswer1() {
        String answer = question1TextField.getText().trim();
        if (answer.equalsIgnoreCase("Paris")) {
            score++;
        }
        updateScore();
    }

    private void checkAnswer2() {
        String answer = question2TextField.getText().trim();
        if (answer.equalsIgnoreCase("Tokyo")) {
            score++;
        }
        updateScore();
    }

    private void checkAnswer3() {
        String answer = question3TextField.getText().trim();
        if (answer.equalsIgnoreCase("Berlin")) {
            score++;
        }
        updateScore();
    }

    private void updateScore() {
        scoreLabel.setText("Your Score: " + score + "/3");
    }

}