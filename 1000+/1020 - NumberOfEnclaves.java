/*
https://leetcode.com/problems/number-of-enclaves/

Given a 2D array A, each cell is 0 (representing sea) or 1 (representing land)
A move consists of walking from one land square 4-directionally to 
another land square, or off the boundary of the grid.

Return the number of land squares in the grid for which we cannot walk off 
the boundary of the grid in any number of moves.

Example 1:
Input: [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: There are three 1s that are enclosed by 0s, 
and one 1 that isn't enclosed because its on the boundary.

Example 2:
Input: [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
Explanation: All 1s are either on the boundary or can reach the boundary.
*/

class Solution {
    private static final int[][] dirs = new int[][]{
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    public int numEnclaves(int[][] arr) {
        if (arr.length <= 2 || arr[0].length <= 2) {
            return 0;
        }

        for (int col = 0; col < arr[0].length; col++) {
            floodFill(arr, 0, col);
            floodFill(arr, arr.length - 1, col);
        }

        for (int row = 1; row < arr.length - 1; row++) {
            floodFill(arr, row, 0);
            floodFill(arr, row, arr[0].length - 1);
        }

        int cnt = 0;
        for (int row = 1; row < arr.length - 1; row++) {
            for (int col = 1; col < arr[0].length - 1; col++) {
                if (arr[row][col] == 1) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private void floodFill(int[][] arr, int row, int col) {
        if (!withinBounds(arr, row, col) || arr[row][col] != 1) {
            return;
        }

        arr[row][col] = 2;
        for (int[] dir : dirs) {
            floodFill(arr, row + dir[0], col + dir[1]);
        }
    }

    private boolean withinBounds(int[][] arr, int row, int col) {
        return row >= 0 && col >= 0 && row < arr.length && col < arr[0].length;
    }
}
