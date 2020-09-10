/*
https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/

Given a m x n grid. Each cell of the grid represents a street. The street of grid[i][j] can be:
    . 1 which means a street connecting the left cell and the right cell.
    . 2 which means a street connecting the upper cell and the lower cell.
    . 3 which means a street connecting the left cell and the lower cell.
    . 4 which means a street connecting the right cell and the lower cell.
    . 5 which means a street connecting the left cell and the upper cell.
    . 6 which means a street connecting the right cell and the upper cell.

You will initially start at the street of the upper-left cell (0,0).
A valid path in the grid is a path which starts from the upper left cell (0,0)
and ends at the bottom-right cell (m - 1, n - 1). The path should only follow the streets.

Notice that you are not allowed to change any street.
Return true if there is a valid path in the grid or false otherwise.

Example 1:
Input: grid = [[2,4,3],[6,5,2]]
Output: true
Explanation: You can start at cell (0, 0) and visit all the cells of the grid to reach (m - 1, n - 1).

Example 2:
Input: grid = [[1,2,1],[1,2,1]]
Output: false
Explanation: You can see that cell (0, 0) is not connected with any street of any other cell
and you will get stuck at cell (0, 0)

Example 3:
Input: grid = [[1,1,2]]
Output: false
Explanation: You will get stuck at cell (0, 1) and you cannot reach cell (0, 2).

Example 4:
Input: grid = [[1,1,1,1,1,1,3]]
Output: true

Example 5:
Input: grid = [[2],[2],[2],[2],[2],[2],[6]]
Output: true

Constraints:
    . m == grid.length
    . n == grid[i].length
    . 1 <= m, n <= 300
    . 1 <= grid[i][j] <= 6
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean hasValidPath(int[][] grid) {
        Map<Integer, int[][]> map = init();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return dfs(grid, 0, 0, map, visited);
    }

    private boolean dfs(int[][] grid, int row, int col, Map<Integer, int[][]> map, boolean[][] visited) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return true;
        }

        visited[row][col] = true;
        
        for (int[] dir : map.get(grid[row][col])) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (isValidCell(newRow, newCol, grid) && !visited[newRow][newCol]) {
                for (int[] newDirs : map.get(grid[newRow][newCol])) {
                    // When trying all paths for this new cell, if you can visit the cur cell
                    // then this is a connection b/w this new cell and cur cell
                    // so traverse this path
                    if (newRow + newDirs[0] == row && newCol + newDirs[1] == col) {
                        if (dfs(grid, newRow, newCol, map, visited)) {
                            return true;
                        }
                        break;
                    }
                }
            }
        }

        return false;
    }

    private boolean isValidCell(int row, int col, int[][] grid) {
        return row >= 0 && col >= 0 && row < grid.length && col < grid[0].length;
    }

    private Map<Integer, int[][]> init() {
        Map<Integer, int[][]> map = new HashMap<>();
        map.put(1, new int[][]{{0, -1}, {0, 1}});
        map.put(2, new int[][]{{-1, 0}, {1, 0}});
        map.put(3, new int[][]{{0, -1}, {1, 0}});
        map.put(4, new int[][]{{0, 1}, {1, 0}});
        map.put(5, new int[][]{{-1, 0}, {0, -1}});
        map.put(6, new int[][]{{-1, 0}, {0, 1}});
        return map;
    }
}
