package math.problems.matrices;

//Problem: Search in a sorted matrix

//Logic: 
//1. Initialize two pointers i and j to the top-left and bottom-right corners of the matrix, respectively.
//2. Compare the element at matrix[i][j] with the target value.
//3. If the element is equal to the target, return true.
//4. If the element is greater than the target, move the pointer j to the left.
//5. If the element is less than the target, move the pointer i to the bottom.

//Time Complexity: O(m + n), where m and n are the number of rows and columns in the matrix, respectively.
//Space Complexity: O(1), since the function does not use any additional data structures.

public class SearchInSortedMatrix {

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int target = 5;
        System.out.println(searchMatrix(matrix, target));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int i = 0, j = cols - 1;

        while(i < rows && j >= 0){
            if(matrix[i][j] == target){
                return true;
            } else if(matrix[i][j] > target){
                j--;
            } else {
                i++;
            }   
        }
        return false;

    }

}
