package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuMain extends JFrame {

    public SudokuMain() {
        setTitle("Sudoku Game");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        JLabel titleLabel = new JLabel("Sudoku Game", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 30));
        
        // Difficulty buttons
        JButton easyButton = new JButton("Easy");
        JButton mediumButton = new JButton("Medium");
        JButton hardButton = new JButton("Hard");
        
        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));
        buttonPanel.add(easyButton);
        buttonPanel.add(mediumButton);
        buttonPanel.add(hardButton);

        // Add action listeners for difficulty levels
        easyButton.addActionListener(e -> startGame(4));
        mediumButton.addActionListener(e -> startGame(6));
        hardButton.addActionListener(e -> startGame(9));

        // Layout and adding components
        setLayout(new BorderLayout());
        add(titleLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    private void startGame(int gridSize) {
        new SudokuGame(gridSize).setVisible(true);
        this.dispose(); // Close the main menu
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SudokuMain mainFrame = new SudokuMain();
            mainFrame.setVisible(true);
        });
    }
}
