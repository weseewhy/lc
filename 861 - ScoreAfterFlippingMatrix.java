/*
https://leetcode.com/problems/score-after-flipping-matrix/

We have a two dimensional matrix A where each value is 0 or 1.
A move consists of choosing any row or column, and toggling each value in that row or column:
changing all 0s to 1s, and all 1s to 0s.
After making any number of moves, every row of this matrix is interpreted as a binary number,
and the score of the matrix is the sum of these numbers.
Return the highest possible score.

Example 1:
Input: [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
Output: 39
Explanation:
Toggled to [[1,1,1,1],[1,0,0,1],[1,1,1,1]].
0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
*/

class Solution {
    public int matrixScore(int[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            if (arr[row][0] == 0) {
                flipRow(arr, row);
            }
        }

        for (int col = 1; col < arr[0].length; col++) {
            if (!colHasMoreOnesThanZeroes(arr, col)) {
                flipCol(arr, col);
            }
        }

        return calculateMatrixScore(arr);
    }

    private void flipRow(int[][] arr, int row) {
        for (int col = 0; col < arr[0].length; col++) {
            arr[row][col] = 1 - arr[row][col];
        }
    }

    private void flipCol(int[][] arr, int col) {
        for (int row = 0; row < arr.length; row++) {
            arr[row][col] = 1 - arr[row][col];
        }
    }

    private boolean colHasMoreOnesThanZeroes(int[][] arr, int col) {
        int cnt = 0;
        for (int row = 0; row < arr.length; row++) {
            cnt += arr[row][col];
        }

        return cnt > arr.length / 2;
    }

    private int calculateMatrixScore(int[][] arr) {
        int score = 0;
        for (int[] row : arr) {
            score += calculateRowScore(row);
        }

        return score;
    }

    private int calculateRowScore(int[] row) {
        int score = 0;
        int mul = 1;
        for (int i = row.length - 1; i >= 0; i--) {
            score += row[i] * mul;
            mul *= 2;
        }

        return score;
    }
}
