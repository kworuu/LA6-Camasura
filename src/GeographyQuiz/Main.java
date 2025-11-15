package GeographyQuiz;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GeographyQuiz geographyQuiz = new GeographyQuiz();
            geographyQuiz.setVisible(true);
        });
    }
}