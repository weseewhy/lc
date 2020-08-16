/*
https://leetcode.com/problems/pacific-atlantic-water-flow/

Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent,
the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Example:
Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:
[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0) {
            return Collections.emptyList();
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] status = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            fill(row, 0, status, matrix, 1);
            fill(row, cols - 1, status, matrix, 2);
        }
        for (int col = 0; col < cols; col++) {
            fill(0, col, status, matrix, 1);
            fill(rows - 1, col, status, matrix, 2);
        }

        List<List<Integer>> out = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (status[row][col] == 3) {
                    out.add(Arrays.asList(row, col));
                }
            }
        }
        return out;
    }

    private void fill(int row, int col, int[][] status, int[][] matrix, int flag) {
        if ((status[row][col] & flag) == flag) {
            // already filled
            return;
        }

        status[row][col] |= flag;
        
        if (inBounds(row + 1, col, matrix) && matrix[row][col] <= matrix[row + 1][col]) {
            fill(row + 1, col, status, matrix, flag);
        }
        if (inBounds(row - 1, col, matrix) && matrix[row][col] <= matrix[row - 1][col]) {
            fill(row - 1, col, status, matrix, flag);
        }
        if (inBounds(row, col + 1, matrix) && matrix[row][col] <= matrix[row][col + 1]) {
            fill(row, col + 1, status, matrix, flag);
        }
        if (inBounds(row, col - 1, matrix) && matrix[row][col] <= matrix[row][col - 1]) {
            fill(row, col - 1, status, matrix, flag);
        }
    }

    private boolean inBounds(int row, int col, int[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }
}
