/*
https://leetcode.com/problems/unique-paths/

A robot is located at the top-left corner of a m x n grid.
The robot can only move either down or right at any point in time. 
The robot is trying to reach the bottom-right corner of the grid.

How many possible unique paths are there?

Example 1:
Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right

Example 2:
Input: m = 7, n = 3
Output: 28
*/

class Solution {
    public int uniquePaths(int rows, int cols) {
        int[] dist = new int[cols];
        dist[cols - 1] = 1;

        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                if (col < cols - 1) {
                    dist[col] += dist[col + 1];
                }
            }
        }

        return dist[0];
    }
}
