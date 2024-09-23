package game;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GridPanel extends JPanel {
    private JTextField[][] cells;

    public GridPanel(int gridSize, int[][] predefinedNumbers) {
        setLayout(new GridLayout(gridSize, gridSize));
        cells = new JTextField[gridSize][gridSize];

        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                JTextField cell = new JTextField();

                if (predefinedNumbers[row][col] != 0) {
                    cell.setText(String.valueOf(predefinedNumbers[row][col]));
                    cell.setHorizontalAlignment(SwingConstants.CENTER);
                    cell.setFont(new Font("Serif", Font.BOLD, 18));
                    cell.setEditable(false);
                    cell.setOpaque(true);
                    cell.setBackground(new Color(173, 216, 230));
                } else {
                    cell.setHorizontalAlignment(SwingConstants.CENTER);
                    cell.setFont(new Font("Serif", Font.PLAIN, 18));
                }

                cell.setBorder(createCustomBorder(row, col, gridSize));
                cells[row][col] = cell;
                add(cell);
            }
        }
    }

    private Border createCustomBorder(int row, int col, int gridSize) {
        int thickness = 2;
        boolean right = false, bottom = false;

        if (gridSize == 9) {
            right = (col + 1) % 3 == 0 && col != gridSize - 1;
            bottom = (row + 1) % 3 == 0 && row != gridSize - 1;
        } else if (gridSize == 6) {
            right = (col + 1) % 3 == 0 && col != gridSize - 1;
            bottom = (row + 1) % 2 == 0 && row != gridSize - 1;
        } else if (gridSize == 4) {
            right = (col + 1) % 2 == 0 && col != gridSize - 1;
            bottom = (row + 1) % 2 == 0 && row != gridSize - 1;
        }

        return BorderFactory.createMatteBorder(1, 1, bottom ? thickness : 1, right ? thickness : 1, Color.BLACK);
    }

    public int[][] getUserInput() {
        int[][] userInput = new int[cells.length][cells[0].length];
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                String text = cells[row][col].getText();
                if (!text.isEmpty()) {
                    try {
                        userInput[row][col] = Integer.parseInt(text);
                    } catch (NumberFormatException e) {
                        userInput[row][col] = 0; // Handle invalid input
                    }
                } else {
                    userInput[row][col] = 0; // No input means empty cell
                }
            }
        }
        return userInput;
    }

    public boolean isSolutionCorrect(int[][] correctSolution) {
        int[][] userInput = getUserInput(); // Get the user's input

        for (int row = 0; row < correctSolution.length; row++) {
            for (int col = 0; col < correctSolution[row].length; col++) {
                // Ensure we ignore predefined numbers (editable ones are supposed to be 0)
                if (correctSolution[row][col] != 0 && userInput[row][col] != correctSolution[row][col]) {
                    return false; // Return false if any number is incorrect
                }
            }
        }
        return true; 
    }
}

