package game;

public class SudokuSolver {
    private int[][] board;
    private int gridSize;

    public SudokuSolver(int[][] board, int gridSize) {
        this.board = new int[gridSize][gridSize];
        this.gridSize = gridSize;
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                this.board[i][j] = board[i][j];
            }
        }
        solveSudoku(0, 0);
    }

    public int[][] getSolution() {
        return board;
    }

    private boolean solveSudoku(int row, int col) {
        if (row == gridSize - 1 && col == gridSize) return true;
        if (col == gridSize) {
            row++;
            col = 0;
        }

        if (board[row][col] != 0) return solveSudoku(row, col + 1);

        for (int num = 1; num <= gridSize; num++) {
            if (isValid(board, row, col, num, gridSize)) {
                board[row][col] = num;
                if (solveSudoku(row, col + 1)) return true;
                board[row][col] = 0;
            }
        }
        return false;
    }

    private boolean isValid(int[][] board, int row, int col, int number, int gridSize) {
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
}
