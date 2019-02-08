/*
https://leetcode.com/problems/number-of-islands/

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input:
11110
11010
11000
00000
Output: 1

Example 2:
Input:
11000
11000
00100
00011
Output: 3
*/

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int cnt = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] != 1) {
                    cnt++;
                    markAsVisited(grid, i, j, visited);
                }
            }
        }

        return cnt;
    }

    private void markAsVisited(char[][] grid, int i, int j, int[][] visited) {
        int maxRow = grid.length;
        int maxCol = grid[0].length;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(i, j));
        visited[i][j] = 1;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.col + 1 < maxCol && visited[cur.row][cur.col + 1] == 0 && grid[cur.row][cur.col + 1] == '1') {
                q.offer(new Point(cur.row, cur.col + 1));
                visited[cur.row][cur.col + 1] = 1;
            }

            if (cur.col - 1 >= 0 && visited[cur.row][cur.col - 1] == 0 && grid[cur.row][cur.col - 1] == '1') {
                q.offer(new Point(cur.row, cur.col - 1));
                visited[cur.row][cur.col - 1] = 1;
            }

            if (cur.row + 1 < maxRow && visited[cur.row + 1][cur.col] == 0 && grid[cur.row + 1][cur.col] == '1') {
                q.offer(new Point(cur.row + 1, cur.col));
                visited[cur.row + 1][cur.col] = 1;
            }

            if (cur.row - 1 >= 0 && visited[cur.row - 1][cur.col] == 0 && grid[cur.row - 1][cur.col] == '1') {
                q.offer(new Point(cur.row - 1, cur.col));
                visited[cur.row - 1][cur.col] = 1;
            }
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
