/*
https://leetcode.com/problems/unique-paths-iii/

On a 2-dimensional grid, there are 4 types of squares:
   . 1 represents the starting square.  There is exactly one starting square.
   . 2 represents the ending square.  There is exactly one ending square.
   . 0 represents empty squares we can walk over.
   . -1 represents obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, 
that walk over EVERY non-obstacle square EXACTLY once.

Example 1:
Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

Example 2:
Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)

Example 3:
Input: [[0,1],[2,0]]
Output: 0
Explanation: 
There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.
*/

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int uniquePathsIII(int[][] grid) {
        Point src, dest;
        src = dest = null;

        int pathLength = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    src = new Point(row, col);
                    pathLength++;
                } else if (grid[row][col] == 2) {
                    dest = new Point(row, col);
                } else if (grid[row][col] == 0) {
                    pathLength++;
                }
            }
        }

        Set<Point> visited = new HashSet<>();
        return paths(grid, src, dest, visited, pathLength);
    }

    private int paths(int[][] grid, Point src, Point dest, Set<Point> visited, int pathLength) {
        if (src.equals(dest)) {
            return visited.size() == pathLength ? 1 : 0;
        } else if (!isValidPoint(src, grid) || visited.contains(src) || grid[src.row][src.col] == -1) {
            return 0;
        }

        visited.add(src);
        int cnt = paths(grid, src.left(), dest, visited, pathLength)
                + paths(grid, src.right(), dest, visited, pathLength)
                + paths(grid, src.up(), dest, visited, pathLength)
                + paths(grid, src.down(), dest, visited, pathLength);

        visited.remove(src);
        return cnt;
    }

    private boolean isValidPoint(Point point, int[][] grid) {
        return point.row >= 0 && point.col >= 0 && point.row < grid.length && point.col < grid[0].length;
    }
}

class Point {
    int row;
    int col;

    Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) {
            return false;
        }

        Point other = (Point) obj;
        return this.row == other.row && this.col == other.col;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.row) * Integer.hashCode(this.col);
    }

    Point down() {
        return new Point(this.row + 1, this.col);
    }

    Point up() {
        return new Point(this.row - 1, this.col);
    }

    Point left() {
        return new Point(this.row, this.col - 1);
    }

    Point right() {
        return new Point(this.row, this.col + 1);
    }

    @Override
    public String toString() {
        return String.format("[%d,%d]", this.row, this.col);
    }
}
