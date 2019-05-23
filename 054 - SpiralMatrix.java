/*
https://leetcode.com/problems/spiral-matrix/

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> path = new ArrayList<>();
        if (matrix.length > 0) {
            spiralOrder(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1, path);
        }
        return path;
    }

    private void spiralOrder(int[][] matrix, int minRow, int maxRow, int minCol, int maxCol, List<Integer> path) {
        if (minRow > maxRow || minCol > maxCol) return;

        // Right
        for (int col = minCol; col <= maxCol; col++) {
            path.add(matrix[minRow][col]);
        }

        // Down
        for (int row = minRow + 1; row <= maxRow; row++) {
            path.add(matrix[row][maxCol]);
        }

        // Left
        if (maxRow > minRow) {
            for (int col = maxCol - 1; col >= minCol; col--) {
                path.add(matrix[maxRow][col]);
            }
        }

        // Up
        if (maxCol > minCol) {
            for (int row = maxRow - 1; row > minRow; row--) {
                path.add(matrix[row][minCol]);
            }
        }

        spiralOrder(matrix, minRow + 1, maxRow - 1, minCol + 1, maxCol - 1, path);
    }
}
