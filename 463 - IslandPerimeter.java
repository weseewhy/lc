/*
https://leetcode.com/problems/island-perimeter/

You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
Grid cells are connected horizontally/vertically (not diagonally). 
The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). 
One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. 
Determine the perimeter of the island.

Example:
Input:
[
 [0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]
]
Output: 16
*/

class Solution {
    public int islandPerimeter(int[][] grid) {
        int total = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                boolean isLand = grid[row][col] == 1;
                if (isLand) {
                    // each block has 4 sides
                    total += 4;

                    // remove shared sides with right and bottom blocks
                    total -= 2 * commonEdgesToRightAndBottom(grid, row, col);

                }
            }
        }

        return total;
    }

    // will check only for right or bottom neighbors
    private int commonEdgesToRightAndBottom(int[][] grid, int row, int col) {
        int cnt = 0;

        // right
        if (col < grid[0].length - 1 && grid[row][col + 1] == 1) {
            cnt++;
        }

        // bottom
        if (row < grid.length - 1 && grid[row + 1][col] == 1) {
            cnt++;
        }

        return cnt;
    }
}
