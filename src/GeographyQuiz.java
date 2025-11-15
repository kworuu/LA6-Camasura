import java.awt.*;
import java.awt.event.*;

public class GeographyQuiz extends Frame {
    private Panel panel1, panel2, panel3, panel4;
    private TextField question1TextField, question2TextField, question3TextField;
    private Label scoreLabel;
    private Button nextButton, backButton;
    private CardLayout cardLayout;
    private Panel mainPanel;
    private int score = 0;
    private int currentPanel = 1;
    
    public GeographyQuiz() {
        setTitle("Geography Quiz");
        setSize(500, 250);
        setLayout(new BorderLayout());
        
        // Create CardLayout for switching panels
        cardLayout = new CardLayout();
        mainPanel = new Panel(cardLayout);
        
        // Create all panels
        createPanel1();
        createPanel2();
        createPanel3();
        createPanel4();
        
        // Add panels to main panel
        mainPanel.add(panel1, "Panel1");
        mainPanel.add(panel2, "Panel2");
        mainPanel.add(panel3, "Panel3");
        mainPanel.add(panel4, "Panel4");
        
        add(mainPanel, BorderLayout.CENTER);
        
        // Window closing event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        setVisible(true);
    }
    
    private void createPanel1() {
        panel1 = new Panel(new BorderLayout());
        panel1.setName("panel1");
        
        Panel contentPanel = new Panel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        
        Label questionLabel = new Label("What is the capital of France?");
        question1TextField = new TextField(20);
        question1TextField.setName("question1TextField");
        
        contentPanel.add(questionLabel);
        contentPanel.add(question1TextField);
        
        // Score label
        scoreLabel = new Label("Your Score: 0/3");
        scoreLabel.setName("scoreLabel");
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 14));
        
        // Button panel
        Panel buttonPanel = new Panel(new FlowLayout(FlowLayout.RIGHT));
        nextButton = new Button("Next");
        nextButton.setName("nextButton");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentPanel == 1) {
                    checkAnswer1();
                    currentPanel = 2;
                    cardLayout.show(mainPanel, "Panel2");
                }
            }
        });
        buttonPanel.add(nextButton);
        
        panel1.add(contentPanel, BorderLayout.CENTER);
        panel1.add(scoreLabel, BorderLayout.NORTH);
        panel1.add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void createPanel2() {
        panel2 = new Panel(new BorderLayout());
        panel2.setName("panel2");
        
        Panel contentPanel = new Panel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        
        Label questionLabel = new Label("What is the capital of Japan?");
        question2TextField = new TextField(20);
        question2TextField.setName("question2TextField");
        
        contentPanel.add(questionLabel);
        contentPanel.add(question2TextField);
        
        // Score label for panel 2
        Label scoreLabel2 = new Label("Your Score: 0/3");
        scoreLabel2.setName("scoreLabel");
        scoreLabel2.setFont(new Font("Arial", Font.BOLD, 14));
        
        // Button panel
        Panel buttonPanel = new Panel(new FlowLayout(FlowLayout.RIGHT));
        
        Button backBtn = new Button("Back");
        backBtn.setName("backButton");
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentPanel = 1;
                cardLayout.show(mainPanel, "Panel1");
            }
        });
        
        Button nextBtn = new Button("Next");
        nextBtn.setName("nextButton");
        nextBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentPanel == 2) {
                    checkAnswer2();
                    currentPanel = 3;
                    cardLayout.show(mainPanel, "Panel3");
                }
            }
        });
        
        buttonPanel.add(backBtn);
        buttonPanel.add(nextBtn);
        
        panel2.add(contentPanel, BorderLayout.CENTER);
        panel2.add(scoreLabel2, BorderLayout.NORTH);
        panel2.add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void createPanel3() {
        panel3 = new Panel(new BorderLayout());
        panel3.setName("panel3");
        
        Panel contentPanel = new Panel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        
        Label questionLabel = new Label("What is the capital of Germany?");
        question3TextField = new TextField(20);
        question3TextField.setName("question3TextField");
        
        contentPanel.add(questionLabel);
        contentPanel.add(question3TextField);
        
        // Score label for panel 3
        Label scoreLabel3 = new Label("Your Score: 0/3");
        scoreLabel3.setName("scoreLabel");
        scoreLabel3.setFont(new Font("Arial", Font.BOLD, 14));
        
        // Button panel
        Panel buttonPanel = new Panel(new FlowLayout(FlowLayout.RIGHT));
        
        Button backBtn = new Button("Back");
        backBtn.setName("backButton");
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentPanel = 2;
                cardLayout.show(mainPanel, "Panel2");
            }
        });
        
        Button nextBtn = new Button("Next");
        nextBtn.setName("nextButton");
        nextBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentPanel == 3) {
                    checkAnswer3();
                    currentPanel = 4;
                    cardLayout.show(mainPanel, "Panel4");
                }
            }
        });
        
        buttonPanel.add(backBtn);
        buttonPanel.add(nextBtn);
        
        panel3.add(contentPanel, BorderLayout.CENTER);
        panel3.add(scoreLabel3, BorderLayout.NORTH);
        panel3.add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void createPanel4() {
        panel4 = new Panel(new BorderLayout());
        panel4.setName("panel4");
        
        Panel contentPanel = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 40));
        Label congratsLabel = new Label("Congratulations! You've completed the quiz!");
        congratsLabel.setFont(new Font("Arial", Font.BOLD, 16));
        contentPanel.add(congratsLabel);
        
        // Score label for panel 4
        Label scoreLabel4 = new Label("Your Score: 0/3");
        scoreLabel4.setName("scoreLabel");
        scoreLabel4.setFont(new Font("Arial", Font.BOLD, 14));
        
        // Button panel with only back button
        Panel buttonPanel = new Panel(new FlowLayout(FlowLayout.RIGHT));
        Button backBtn = new Button("Back");
        backBtn.setName("backButton");
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentPanel = 3;
                cardLayout.show(mainPanel, "Panel3");
            }
        });
        buttonPanel.add(backBtn);
        
        panel4.add(contentPanel, BorderLayout.CENTER);
        panel4.add(scoreLabel4, BorderLayout.NORTH);
        panel4.add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void checkAnswer1() {
        String answer = question1TextField.getText().trim();
        if (answer.equalsIgnoreCase("Paris")) {
            score++;
        }
        updateAllScoreLabels();
    }
    
    private void checkAnswer2() {
        String answer = question2TextField.getText().trim();
        if (answer.equalsIgnoreCase("Tokyo")) {
            score++;
        }
        updateAllScoreLabels();
    }
    
    private void checkAnswer3() {
        String answer = question3TextField.getText().trim();
        if (answer.equalsIgnoreCase("Berlin")) {
            score++;
        }
        updateAllScoreLabels();
    }
    
    private void updateAllScoreLabels() {
        String scoreText = "Your Score: " + score + "/3";
        
        // Update score labels in all panels
        Component[] components1 = panel1.getComponents();
        for (Component c : components1) {
            if (c instanceof Label && c.getName() != null && c.getName().equals("scoreLabel")) {
                ((Label) c).setText(scoreText);
            }
        }
        
        Component[] components2 = panel2.getComponents();
        for (Component c : components2) {
            if (c instanceof Label && c.getName() != null && c.getName().equals("scoreLabel")) {
                ((Label) c).setText(scoreText);
            }
        }
        
        Component[] components3 = panel3.getComponents();
        for (Component c : components3) {
            if (c instanceof Label && c.getName() != null && c.getName().equals("scoreLabel")) {
                ((Label) c).setText(scoreText);
            }
        }
        
        Component[] components4 = panel4.getComponents();
        for (Component c : components4) {
            if (c instanceof Label && c.getName() != null && c.getName().equals("scoreLabel")) {
                ((Label) c).setText(scoreText);
            }
        }
    }
    
    public static void main(String[] args) {
        new GeographyQuiz();
    }
}