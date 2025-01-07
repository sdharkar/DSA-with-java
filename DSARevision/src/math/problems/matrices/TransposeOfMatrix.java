package math.problems.matrices;

//Problem: Transpose of a matrix

//Logic: 
//1. Initialize a new matrix to hold the transpose of the input matrix.
//2. Iterate through the rows and columns of the input matrix.
//3. Swap the rows and columns of the input matrix and store the result in the transpose matrix.
//4. Return the transpose matrix.

//Algorithm:
//1. Define a function transpose(matrix) that takes a matrix as an argument.
//2. Initialize a new matrix result with the same dimensions as the input matrix.
//3. Iterate through the rows and columns of the input matrix.
//4. Swap the rows and columns of the input matrix and store the result in the transpose matrix.
//5. Return the transpose matrix.

public class TransposeOfMatrix {

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = transpose(matrix);

        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[0].length; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][]  result = new int[col][row];

        for(int i = 0; i < row; i++){
            for(int j=0; j < col; j++){
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

}
