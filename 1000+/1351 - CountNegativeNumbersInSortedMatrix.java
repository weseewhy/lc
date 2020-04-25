/*
https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/

Given a m * n matrix grid which is sorted in non-increasing order both row-wise and column-wise.
Return the number of negative numbers in grid.

Example 1:
Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8

Example 2:
Input: grid = [[3,2],[1,0]]
Output: 0

Example 3:
Input: grid = [[1,-1],[-1,-1]]
Output: 3

Example 4:
Input: grid = [[-1]]
Output: 1
*/

class Solution {
    public int countNegatives(int[][] grid) {
        int cnt = 0;
        
        int row = grid.length - 1;
        int col = 0;
        int maxCol = grid[0].length - 1;

        // start from left bottom and traverse upwards
        while (row >= 0 && col <= maxCol) {
            int val = grid[row][col];
            if (val < 0) {
                cnt += maxCol - col + 1;
                row--;
            } else {
                col++;
            }
        }

        return cnt;
    }
}
