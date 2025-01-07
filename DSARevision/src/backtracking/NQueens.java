package backtracking;

import java.util.*;

// problem: Solve the N-Queens problem using backtracking.
//logic: Use backtracking to find all possible solutions for the N-Queens problem.
//Algorithm:
//1. Define a function solveNQueens(n) that returns a list of all possible solutions for the N-Queens problem.
//2. Call the solveNQueens function with the desired number of queens.
//3. Print the solutions.

public class NQueens {

    // Main method to initiate the solving process
    public static void main(String[] args) {
        int n = 4; // Change this value for different board sizes
        solveNQueens(n);
    }

    // Method to solve the N-Queens problem
    static void solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>(); // To store the results
        char[][] board = new char[n][n]; // Initialize the board
        for (char[] row : board) {
            Arrays.fill(row, '.'); // Fill the board with empty cells
        }
        backtrack(0, board, result); // Start the backtracking process
        printSolution(result); // Print the solutions
    }

    // Backtracking method to place queens on the board
    static void backtrack(int row, char[][] board, List<List<String>> result) {
        if (row == board.length) { // If all rows are filled
            result.add(construct(board)); // Add the board configuration to the result
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(row, col, board)) { // Check if it's safe to place a queen at (row, col)
                board[row][col] = 'Q'; // Place the queen
                backtrack(row + 1, board, result); // Move to the next row
                board[row][col] = '.'; // Remove the queen (backtrack)
            }
        }
    }

    // Method to check if it's safe to place a queen at (row, col)
    static boolean isSafe(int row, int col, char[][] board) {
        // Check the column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check the left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check the right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true; // If no conflicts, it's safe to place the queen
    }

    // Method to construct the board configuration as a list of strings
    static List<String> construct(char[][] board) {
        List<String> path = new ArrayList<>();
        for (char[] row : board) {
            path.add(new String(row));
        }
        return path;
    }

    // Method to print the list of solutions
    static void printSolution(List<List<String>> solutions) {
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row); // Print each row of the solution
            }
            System.out.println(); // Print a blank line between different solutions
        }
    }
}
