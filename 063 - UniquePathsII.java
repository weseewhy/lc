/*
https://leetcode.com/problems/unique-paths-ii/

A robot is located at the top-left corner of a m x n grid. The robot can only move either down 
or right at any point in time. The robot is trying to reach the bottom-right corner of the grid.

Now consider if some obstacles are added to the grids.
An obstacle and empty space is marked as 1 and 0 respectively in the grid.

How many unique paths would there be?

Example 1:
Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
*/

class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int[] dist = new int[grid[0].length];
        dist[grid[0].length - 1] = 1;

        for (int row = grid.length - 1; row >= 0; row--) {
            for (int col = grid[0].length - 1; col >= 0; col--) {
                if (grid[row][col] == 1) {
                    dist[col] = 0;
                } else if (col < grid[0].length - 1) {
                    dist[col] += dist[col + 1];
                }
            }
        }

        return dist[0];
    }
}
