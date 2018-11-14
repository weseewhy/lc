/*
https://leetcode.com/problems/set-matrix-zeroes/description/

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:
Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]

Example 2:
Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
*/

class Solution {
    public void setZeroes(int[][] m) {
        boolean firstRowHasZero = false;
        for (int col = 0; col < m[0].length; col++) {
            if (m[0][col] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        boolean firstColHasZero = false;
        for (int row = 0; row < m.length; row++) {
            if (m[row][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        for (int row = 1; row < m.length; row++) {
            for (int col = 1; col < m[0].length; col++) {
                if (m[row][col] == 0) {
                    m[row][0] = 0;
                    m[0][col] = 0;
                }
            }
        }

        for (int row = 1; row < m.length; row++) {
            for (int col = 1; col < m[0].length; col++) {
                if (m[row][0] == 0 || m[0][col] == 0) {
                    m[row][col] = 0;
                }
            }
        }

        if (firstRowHasZero) {
            for (int col = 0; col < m[0].length; col++) {
                m[0][col] = 0;
            }
        }

        if (firstColHasZero) {
            for (int row = 0; row < m.length; row++) {
                m[row][0] = 0;
            }
        }
    }
}
