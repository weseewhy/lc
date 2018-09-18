/*
https://leetcode.com/problems/magic-squares-in-grid/

A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that
each row, column, and both diagonals all have the same sum.
Given an grid of integers, how many 3 x 3 "magic square" subgrids are there? (Each subgrid is contiguous).

Example 1:
Input: [[4,3,8,4],
        [9,5,1,9],
        [2,7,6,2]]
Output: 1
Explanation:
The following subgrid is a 3 x 3 magic square:
438
951
276

while this one is not:
384
519
762

In total, there is only one magic square inside the given grid.
*/

import java.util.HashSet;
import java.util.Set;

public class MagicSquaresInGrid {
    public int numMagicSquaresInside(int[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (isMagicSquare(grid, i, j, 3)) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private boolean isMagicSquare(int[][] grid, int row, int col, int squareSize) {
        if (row + squareSize > grid.length || col + squareSize > grid[0].length) {
            return false;
        }

        int maxNum = squareSize * squareSize;
        int magicSum = maxNum * (maxNum + 1) / (2 * squareSize);

        Set<Integer> nums = new HashSet<>();
        for (int i = row; i < row + squareSize; i++) {
            for (int j = col; j < col + squareSize; j++) {
                int cur = grid[i][j];
                if (cur < 1 || cur > maxNum || nums.contains(cur)) {
                    return false;
                } else {
                    nums.add(cur);
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < squareSize; i++) {
            sum += grid[row + i][col + i];
        }
        if (sum != magicSum) {
            return false;
        }

        sum = 0;
        for (int i = 0; i < squareSize; i++) {
            sum += grid[row + i][col + squareSize - i - 1];
        }
        if (sum != magicSum) {
            return false;
        }

        for (int i = row; i < row + squareSize; i++) {
            sum = 0;
            for (int j = col; j < col + squareSize; j++) {
                sum += grid[i][j];
            }

            if (sum != magicSum) {
                return false;
            }
        }

        for (int j = col; j < col + squareSize; j++) {
            sum = 0;
            for (int i = row; i < row + squareSize; i++) {
                sum += grid[i][j];
            }

            if (sum != magicSum) {
                return false;
            }
        }

        return true;
    }
}
