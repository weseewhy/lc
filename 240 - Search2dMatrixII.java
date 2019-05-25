/*
https://leetcode.com/problems/search-a-2d-matrix-ii/

Write an efficient algorithm that searches for a value in an m x n matrix. 
This matrix has the following properties:
    - Integers in each row are sorted in ascending from left to right.
    - Integers in each column are sorted in ascending from top to bottom.

Example:
Consider the following matrix:
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.
Given target = 20, return false.
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        // Start search from top right corner
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            int val = matrix[row][col];
            if (val == target) {
                return true;
            } else if (target < val) {
                // If the cur cell value is greater than target, then eliminate that column
                // Because all the values below in that column are greater than cur
                col--;
            } else {
                // If the cur cell value is smaller than target, then eliminate that row
                // Because all the values to the left are smaller than cur
                row++;
            }
        }

        return false;
    }
}
