/*
https://leetcode.com/problems/coloring-a-border/

Given a 2-dimensional grid of integers, each value in the grid represents the color of the grid 
square at that location. Two squares belong to the same connected component if and only if they have 
the same color and are next to each other in any of the 4 directions.

The border of a connected component is all the squares in the connected component that are either 4-directionally 
adjacent to a square not in the component, or on the boundary of the grid (the first or last row or column).

Given a square at location (r0, c0) in the grid and a color, color the border of the connected component of 
that square with the given color, and return the final grid.

Example 1:
Input: grid = [[1,1],[1,2]], r0 = 0, c0 = 0, color = 3
Output: [[3, 3], [3, 2]]

Example 2:
Input: grid = [[1,2,2],[2,3,2]], r0 = 0, c0 = 1, color = 3
Output: [[1, 3, 3], [2, 3, 3]]

Example 3:
Input: grid = [[1,1,1],[1,1,1],[1,1,1]], r0 = 1, c0 = 1, color = 2
Output: [[2, 2, 2], [2, 1, 2], [2, 2, 2]]
*/

class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        dfs(grid, row, col, grid[row][col]);
        markBorder(grid, color);
        return grid;
    }

    private void dfs(int[][] grid, int row, int col, int color) {
        if (isOutsideGrid(grid, row, col) || grid[row][col] != color) {
            // If outside the grid or a different color cell -- nothing to do
            return;
        }

        // -ve to indicate visited
        grid[row][col] = -color;

        // visit neighbors
        dfs(grid, row, col - 1, color);
        dfs(grid, row, col + 1, color);
        dfs(grid, row - 1, col, color);
        dfs(grid, row + 1, col, color);

        // If inside (4 same color borders), set original color back
        if (has4SameNeighbors(grid, row, col)) {
            grid[row][col] = color;
        }
    }

    private boolean isOutsideGrid(int[][] grid, int row, int col) {
        return row < 0 || col < 0 || row >= grid.length || col >= grid[0].length;
    }

    private boolean hasSameColor(int[][] grid, int row, int col, int color) {
        return !isOutsideGrid(grid, row, col) && Math.abs(grid[row][col]) == Math.abs(color);
    }

    private boolean has4SameNeighbors(int[][] grid, int row, int col) {
        int color = grid[row][col];
        return hasSameColor(grid, row, col - 1, color) &&
                hasSameColor(grid, row, col + 1, color) &&
                hasSameColor(grid, row - 1, col, color) &&
                hasSameColor(grid, row + 1, col, color);
    }

    private void markBorder(int[][] grid, int color) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] < 0) {
                    grid[row][col] = color;
                }
            }
        }
    }
}
