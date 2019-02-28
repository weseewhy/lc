/*
https://leetcode.com/problems/diagonal-traverse/

Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order.

Example:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output:  [1,2,4,7,5,3,6,8,9]
*/

class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[]{};
        }

        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;
        int[] out = new int[(rows + 1) * (cols + 1)];

        boolean up = true;
        int row = 0;
        int col = 0;

        for (int i = 0; i < out.length; i++) {
            out[i] = matrix[row][col];

            if (up) {
                boolean atTop = row == 0;
                boolean atRight = col == cols;

                if (atTop || atRight) {
                    up = false;
                    if (atTop && atRight) {
                        row++;
                    } else if (atTop) {
                        col++;
                    } else {
                        row++;
                    }
                } else {
                    row--;
                    col++;
                }
            } else {
                boolean atBottom = row == rows;
                boolean atLeft = col == 0;

                if (atBottom || atLeft) {
                    up = true;
                    if (atBottom && atLeft) {
                        col++;
                    } else if (atBottom) {
                        col++;
                    } else {
                        row++;
                    }
                } else {
                    row++;
                    col--;
                }
            }
        }

        return out;
    }
}
