package NumberCounter;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Launch the number counter form

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                NumberCounter numberCounter = new NumberCounter();
                numberCounter.setVisible(true);
            }
        });
    }
}
