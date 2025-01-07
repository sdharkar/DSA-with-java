package math.problems.matrices;

//problem: Rotate a matrix by 90 degrees

//logic: 
//1. Transpose the matrix
//2. Reverse each row of the matrix
//3. Return the matrix

//algorithm:
//1. Define a function rotateMatrix(matrix) that takes a matrix as an argument.
//2. Transpose the matrix using a nested loop.
//3. Reverse each row of the matrix using a nested loop.
//4. Return the matrix.

public class RotateMatrixBy90Degrees {

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateMatrix(matrix);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void rotateMatrix(int[][] matrix) {
        int n = matrix.length;

        // Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    
        // Reverse rows
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

}
