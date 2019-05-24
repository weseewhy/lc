/*
https://leetcode.com/problems/minimum-path-sum/

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right
which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.

Example:
Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
*/

class Solution {
    public int minPathSum(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (row == 0 && col == 0) continue;

                if (col == 0) {
                    grid[row][col] += grid[row - 1][0];
                } else if (row == 0) {
                    grid[row][col] += grid[0][col - 1];
                } else {
                    grid[row][col] += Math.min(grid[row - 1][col], grid[row][col - 1]);
                }
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }
}
