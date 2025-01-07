package backtracking;

// Problem: Solve a Sudoku puzzle using backtracking.
// Logic: Use backtracking to find a solution for the Sudoku board.
// Algorithm:
// 1. Define a function isValidPlacement(board, num, row, col) that checks if placing num in the cell at (row, col) would lead to a valid Sudoku board.
// 2. Define a function solveSudoku(board) that solves the Sudoku board using backtracking.
// 3. Define a function printSudoku(board) that prints the Sudoku board.
// 4. Call the solveSudoku function with the initial Sudoku board.
// 5. If a solution is found, call the printSudoku function to print the result.
// 6. If no solution is found, print "No solution exists."



// Algorithm and Logic
// 	1.	Identify the problem:
// 	•	Each empty cell needs a number between 1 and 9.
// 	•	The placement must satisfy Sudoku’s rules: no duplicate numbers in any row, column, or 3x3 sub-grid.
// 	2.	Backtracking Steps:
// 	•	Find an empty cell.
// 	•	Try placing a number (1–9) in the cell.
// 	•	Check if the number placement is valid.
// 	•	If valid, recursively attempt to solve the remaining grid.
// 	•	If the placement leads to a dead end, undo (backtrack) the placement and try the next number.
// 	•	If all numbers fail for a cell, backtrack further.
// 	3.	Base Case:
// 	•	If there are no empty cells, the puzzle is solved.

// Example Sudoku puzzle (0 represents empty cells)
// 5 3 0 0 7 0 0 0 0
// 6 0 0 1 9 5 0 0 0
// 0 9 8 0 0 0 0 6 0
// 8 0 0 0 6 0 0 0 3
// 4 0 0 8 0 3 0 0 1
// 7 0 0 0 2 0 0 0 6
// 0 6 0 0 0 0 2 8 0
// 0 0 0 4 1 9 0 0 5
// 0 0 0 0 8 0 0 7 9
public class SudokuSolver {

    private static final int GRID_SIZE = 9;

    // Method to solve the Sudoku board
    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                // If the cell is empty (marked as 0)
                if (board[row][col] == 0) {
                    // Try placing numbers 1–9
                    for (int num = 1; num <= GRID_SIZE; num++) {
                        if (isValidPlacement(board, num, row, col)) {
                            board[row][col] = num; // Place the number

                            // Recursively try to solve the rest of the board
                            if (solveSudoku(board)) {
                                return true;
                            }

                            // Backtrack if the placement doesn't lead to a solution
                            board[row][col] = 0;
                        }
                    }

                    // If no number fits in this cell, return false
                    return false;
                }
            }
        }
        // If no empty cell is found, the board is solved
        return true;
    }

    // Method to check if placing a number is valid
    private static boolean isValidPlacement(int[][] board, int num, int row, int col) {
        // Check the row
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // Check the column
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Check the 3x3 sub-grid
        int subGridRowStart = (row / 3) * 3;
        int subGridColStart = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[subGridRowStart + i][subGridColStart + j] == num) {
                    return false;
                }
            }
        }

        return true; // Placement is valid
    }

    // Method to print the Sudoku board
    private static void printBoard(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Example Sudoku puzzle (0 represents empty cells)
        int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (solveSudoku(board)) {
            System.out.println("Sudoku solved successfully:");
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }
    }
}
