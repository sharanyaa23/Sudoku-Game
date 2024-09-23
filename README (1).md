
# Sudoku Game

This project is a Sudoku game generator written in Java. It generates Sudoku puzzles of different sizes (4x4, 6x6, and 9x9). The game allows users to play, check their solutions, and provides the correct answer when needed. The generator ensures that the numbers in each subgrid, row, and column are unique according to the rules of Sudoku.


## Features

- 3 Difficulty Levels:

    Easy (4x4 grid)

    Medium (6x6 grid)

    Hard (9x9 grid)
- Backtracking Algorithm: Used to ensure each puzzle has a unique solution.
- Subgrid Uniqueness: Ensures no repeated numbers in rows, columns, or subgrids.
- User Interaction: Allows users to input answers, check their solution, and get feedback on correctness.
- Random Puzzle Generation: Every time a puzzle is generated, it is randomized and unique.
 


## Technologies Used

- Java: Core language used to implement the game.
- Java Swing: Used for creating the GUI components of the game.
- Algorithms: Backtracking and random number generation for filling the Sudoku grid.
## Game Flow
1. Start Screen: Displays the title of the game and options for difficulty levels.
2. Puzzle Display: After selecting a level, a Sudoku puzzle is displayed.
3. Solution Check: Players can input values and check if their solution is correct.
4. Feedback: If the solution is incorrect, the correct solution is displayed.