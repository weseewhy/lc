/*
https://leetcode.com/problems/projection-area-of-3d-shapes/

On a N * N grid, we place some 1 * 1 * 1 cubes that are axis-aligned with the x, y, and z axes.
Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
Now we view the projection of these cubes onto the xy, yz, and zx planes.
A projection is like a shadow, that maps our 3 dimensional figure to a 2 dimensional plane.
Here, we are viewing the "shadow" when looking at the cubes from the top, the front, and the side.
Return the total area of all three projections.

Example 1:
Input: [[2]]
Output: 5

Example 2:
Input: [[1,2],[3,4]]
Output: 17

Example 3:
Input: [[1,0],[0,2]]
Output: 8

Example 4:
Input: [[1,1,1],[1,0,1],[1,1,1]]
Output: 14

Example 5:
Input: [[2,2,2],[2,1,2],[2,2,2]]
Output: 21
*/

public class ProjectionAreaOf3dShapes {
    public int projectionArea(int[][] grid) {
        int sum = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    sum += 1;
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }

            sum += max;
        }

        for (int j = 0; j < grid[0].length; j++) {
            int max = 0;
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }

            sum += max;
        }

        return sum;
    }
}
