package game;

import javax.swing.*;
import java.awt.*;

public class SudokuGame extends JFrame {
    private GridPanel gridPanel;
    private int[][] solution;

    public SudokuGame(int gridSize) {
        setTitle("Sudoku Game - " + gridSize + "x" + gridSize);
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Generate the puzzle and solution
        int[][] puzzle = SudokuGenerator.generateSudoku(gridSize);
        solution = new SudokuSolver(puzzle, gridSize).getSolution();

        // Grid panel
        gridPanel = new GridPanel(gridSize, puzzle);

        // Check solution button
        JButton checkButton = new JButton("Check Solution");
        checkButton.addActionListener(e -> checkSolution());

        // Back button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            new SudokuMain().setVisible(true);
            this.dispose(); // Close the game window
        });

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(checkButton);
        buttonPanel.add(backButton);

        // Layout and adding components
        setLayout(new BorderLayout());
        add(gridPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    // Method to check if the user's solution is correct
    private void checkSolution() {
        if (gridPanel.isSolutionCorrect(solution)) {
            JOptionPane.showMessageDialog(this, "Correct! Well done!", "Result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Incorrect! Try again.", "Result", JOptionPane.ERROR_MESSAGE);
        }
    }
}
