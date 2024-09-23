package game;

import java.util.Random;

public class SudokuGenerator {
    private static final Random random = new Random();

    public static int[][] generateSudoku(int gridSize) {
        int[][] board = new int[gridSize][gridSize];
        generateCompleteSolution(board, gridSize);
        removeNumbersForPuzzle(board, gridSize);
        return board;
    }

    private static boolean generateCompleteSolution(int[][] board, int gridSize) {
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                if (board[row][col] == 0) {
                    int[] numbers = getRandomNumbers(gridSize);
                    for (int number : numbers) {
                        if (isValid(board, row, col, number, gridSize)) {
                            board[row][col] = number;
                            if (generateCompleteSolution(board, gridSize)) {
                                return true;
                            }
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static int[] getRandomNumbers(int gridSize) {
        int[] numbers = new int[gridSize];
        for (int i = 0; i < gridSize; i++) numbers[i] = i + 1;
        for (int i = 0; i < gridSize; i++) {
            int randomIndex = random.nextInt(gridSize);
            int temp = numbers[i];
            numbers[i] = numbers[randomIndex];
            numbers[randomIndex] = temp;
        }
        return numbers;
    }

    private static boolean isValid(int[][] board, int row, int col, int number, int gridSize) {
        for (int i = 0; i < gridSize; i++) {
            if (board[row][i] == number || board[i][col] == number) return false;
        }

        int boxSize = (int) Math.sqrt(gridSize);
        int boxRowStart = row / boxSize * boxSize;
        int boxColStart = col / boxSize * boxSize;

        for (int i = boxRowStart; i < boxRowStart + boxSize; i++) {
            for (int j = boxColStart; j < boxColStart + boxSize; j++) {
                if (board[i][j] == number) return false;
            }
        }
        return true;
    }

    private static void removeNumbersForPuzzle(int[][] board, int gridSize) {
        int numberOfClues = calculateClues(gridSize);
        while (gridSize * gridSize - numberOfClues > 0) {
            int row = random.nextInt(gridSize);
            int col = random.nextInt(gridSize);
            if (board[row][col] != 0) {
                board[row][col] = 0;
                numberOfClues++;
            }
        }
    }

    private static int calculateClues(int gridSize) {
        switch (gridSize) {
            case 4: return 6;
            case 6: return 10;
            case 9: return 30;
            default: return 0;
        }
    }
}
