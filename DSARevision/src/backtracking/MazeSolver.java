package backtracking;

// Problem: Solve a maze using backtracking.
// Logic: Use backtracking to find a path through the maze that goes from the top-left corner to the bottom-right corner.
// Algorithm:
// 1. Define a function solveMaze(maze, x, y, solution) that takes the maze, the current position (x, y), and the solution matrix as input.
// 2. Check if the current position is the bottom-right corner of the maze. If it is, return true.
// 3. If the current position is not walkable, return false.
// 4. Mark the current position as part of the solution.
// 5. Move in all possible directions (Left, Right, Up, Down).
// 6. If any of the moves leads to a solution, return true.
// 7. If none of the moves leads to a solution, backtrack and unmark the current position.
// 8. Return false if no solution is found.

public class MazeSolver {

    // Define the possible directions to move in the maze
    private static final int[] rowDir = {0, 0, -1, 1}; // Up, Down, Left, Right
    private static final int[] colDir = {-1, 1, 0, 0}; // Up, Down, Left, Right

    public static void main(String[] args) {
        // Define the maze
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };

        // Get the number of rows and columns in the maze
        int rows = maze.length;
        int cols = maze[0].length;

        // Create a solution matrix
        int[][] solution = new int[rows][cols];

        // Try to solve the maze
        if (solveMaze(maze, 0, 0, solution)) {
            // If a solution is found, print it
            printSolution(solution);
        } else {
            // If no solution is found, print a message
            System.out.println("No solution exists.");
        }
    }

    // Function to solve the maze using backtracking
    private static boolean solveMaze(int[][] maze, int x, int y, int[][] solution) {
        // Check if the current position is the bottom-right corner of the maze
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            solution[x][y] = 1; // Mark the current position as part of the solution
            return true;
        }

        // Check if the current position is walkable
        if (isSafe(maze, x, y)) {
            solution[x][y] = 1; // Mark the current position as part of the solution

            // Move in all possible directions
            for (int i = 0; i < 4; i++) {
                int nextX = x + rowDir[i];
                int nextY = y + colDir[i];

                // Check if the next position is within the maze and is walkable
                if (nextX >= 0 && nextX < maze.length && nextY >= 0 && nextY < maze[0].length && maze[nextX][nextY] == 1) {
                    // Recursively call the solveMaze function
                    if (solveMaze(maze, nextX, nextY, solution)) {
                        return true;
                    }
                }
            }

            // If no solution is found, backtrack and unmark the current position
            solution[x][y] = 0; // Unmark the current position
            return false;
        }
        return false;
    }

    // Function to check if a position in the maze is walkable
    private static boolean isSafe(int[][] maze, int x, int y) {
        // Check if the position is within the maze and is not blocked
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 1;
    }

    // Function to print the solution
    private static void printSolution(int[][] solution) {
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[0].length; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }
}