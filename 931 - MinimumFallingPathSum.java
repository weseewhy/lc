/*
https://leetcode.com/problems/minimum-falling-path-sum/

Given a square array of integers A, we want the minimum sum of a falling path through A.
A falling path starts at any element in the first row, and chooses one element from each row.
The next row's choice must be in a column that is different from the previous row's column by at most one.

Example:
Input:
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
]
Output: 12
Explanation:  The possible falling paths are:
[1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
[2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
[3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
The falling path with the smallest sum is [1,4,7], so the answer is 12.
*/

class Solution {
    public int minFallingPathSum(int[][] A) {
        for (int row = A.length - 2; row >= 0; row--) {
            for (int col = 0; col < A[0].length; col++) {
                minSum(A, row, col);
            }
        }

        for (int col = 1; col < A[0].length; col++) {
            A[0][0] = Math.min(A[0][0], A[0][col]);
        }

        return A[0][0];
    }

    private void minSum(int[][] arr, int row, int col) {
        if (row < arr.length - 1) {
            int minSum = arr[row + 1][col];
            if (col - 1 >= 0) {
                minSum = Math.min(minSum, arr[row + 1][col - 1]);
            }
            if (col + 1 < arr[0].length) {
                minSum = Math.min(minSum, arr[row + 1][col + 1]);
            }

            arr[row][col] += minSum;
        }
    }
}
