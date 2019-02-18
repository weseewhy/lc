/*
https://leetcode.com/problems/rotting-oranges/

In a given grid, each cell can have one of three values:
    - the value 0 representing an empty cell;
    - the value 1 representing a fresh orange;
    - the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
Return the minimum number of minutes that must elapse until no cell has a fresh orange.  
If this is impossible, return -1 instead.

Example 1:
Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:
Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, 
because rotting only happens 4-directionally.

Example 3:
Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        int total = 0;
        Queue<Point> rotten = new LinkedList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    rotten.offer(new Point(row, col));
                }

                if (grid[row][col] != 0) {
                    total++;
                }
            }
        }

        int curRotten = rotten.size();
        int rottenInNextMin = 0;
        int time = 0;

        while (!rotten.isEmpty()) {
            Point cur = rotten.poll();
            curRotten--;
            total -= 1;
            List<Point> newRottenNeighbors = markNeighborsRotten(grid, cur);
            rottenInNextMin += newRottenNeighbors.size();
            rotten.addAll(newRottenNeighbors);

            if (curRotten == 0 && rottenInNextMin > 0) {
                time++;
                curRotten = rottenInNextMin;
                rottenInNextMin = 0;
            }
        }

        return total > 0 ? -1 : time;
    }

    private List<Point> markNeighborsRotten(int[][] grid, Point p) {
        List<Point> rotten = new ArrayList<>();
        markNeighborRotten(grid, p.row - 1, p.col, rotten);
        markNeighborRotten(grid, p.row + 1, p.col, rotten);
        markNeighborRotten(grid, p.row, p.col - 1, rotten);
        markNeighborRotten(grid, p.row, p.col + 1, rotten);
        return rotten;
    }

    private void markNeighborRotten(int[][] grid, int row, int col, List<Point> rotten) {
        if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == 1) {
            grid[row][col] = 2;
            rotten.add(new Point(row, col));
        }
    }
}

class Point {
    int row;
    int col;

    Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
