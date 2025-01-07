package math.problems.matrices;

//Problem: Add two matrices 

//Logic: 
//1. Initialize a new matrix to hold the result of the addition.
//2. Iterate through the rows and columns of the matrices.
//3. Add the corresponding elements of the matrices and store the result in the result matrix.
//4. Return the result matrix.

//Algorithm:
//1. Define a function addmatrix(matrix1, matrix2) that takes two matrices as arguments.
//2. Initialize a new matrix result with the same dimensions as the input matrices.
//3. Iterate through the rows and columns of the matrices.
//4. Add the corresponding elements of the matrices and store the result in the result matrix.
//5. Return the result matrix.

public class AdditionOfTwoMatrices {

    public static void main(String[] args) {

        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = addmatrix(matrix1, matrix2);

        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[0].length; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] addmatrix(int[][] matrix1, int[][] matrix2){
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

}
