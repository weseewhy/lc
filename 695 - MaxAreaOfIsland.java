/*
https://leetcode.com/problems/max-area-of-island/

Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) 
connected 4-directionally (horizontal or vertical.) 
You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:
[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.

Example 2:
[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
*/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    int curArea = getAreaFromCell(grid, row, col);
                    if (curArea > maxArea) {
                        maxArea = curArea;
                    }
                }
            }
        }

        return maxArea;
    }

    private int getAreaFromCell(int[][] grid, int row, int col) {
        if (!withinBounds(grid, row, col) || grid[row][col] != 1) {
            return 0;
        }

        int cnt = 1;
        grid[row][col] = -1;

        cnt += getAreaFromCell(grid, row - 1, col);
        cnt += getAreaFromCell(grid, row + 1, col);
        cnt += getAreaFromCell(grid, row, col - 1);
        cnt += getAreaFromCell(grid, row, col + 1);
        return cnt;
    }

    private boolean withinBounds(int[][] grid, int row, int col) {
        return row >= 0 &&
                col >= 0 &&
                row < grid.length &&
                col < grid[0].length;
    }
}
