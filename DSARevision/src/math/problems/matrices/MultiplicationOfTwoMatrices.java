package math.problems.matrices;

//Problem: Multiply two matrices

//Logic: 
//1. Initialize a new matrix to hold the result of the multiplication.
//2. Iterate through the rows of the first matrix.
//3. For each row, iterate through the columns of the second matrix.
//4. Calculate the dot product of the current row of the first matrix and the current column of the second matrix.
//5. Add the dot product to the corresponding entry in the result matrix.
//6. Return the result matrix.

//Algorithm:
//1. Define a function multiplyMatrix(matrix1, matrix2) that takes two matrices as arguments.
//2. Initialize a new matrix result with the same number of rows as matrix1 and the same number of columns as matrix2.
//3. Iterate through the rows of matrix1.
//4. For each row, iterate through the columns of matrix2.
//5. Calculate the dot product of the current row of matrix1 and the current column of matrix2.
//6. Add the dot product to the corresponding entry in the result matrix.
//7. Return the result matrix.

public class MultiplicationOfTwoMatrices {

    public static void main(String[] args) {

        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = multiplyMatrix(matrix1, matrix2);

        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[0].length; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }       

    }

    public static int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2) {
        int rowsInMatrix1 = matrix1.length;
        int columnsInMatrix1 = matrix1[0].length; // same as rows in matrix2
        int columnsInMatrix2 = matrix2[0].length;
        int[][] result = new int[rowsInMatrix1][columnsInMatrix2];

        for (int row = 0; row < rowsInMatrix1; row++) {
            for (int col = 0; col < columnsInMatrix2; col++) {
                for (int k = 0; k < columnsInMatrix1; k++) {
                    result[row][col] += matrix1[row][k] * matrix2[k][col];
                }
            }
        }
        return result;
    }
}
