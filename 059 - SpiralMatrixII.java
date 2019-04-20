/*
https://leetcode.com/problems/spiral-matrix-ii/

Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:
Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];

        int row = 0;
        int col = -1;
        int num = 0;

        int size = n;
        while (num < n * n) {
            for (int j = 0; j < size; j++) {
                arr[row][++col] = ++num;
            }

            for (int j = 0; j < size - 1; j++) {
                arr[++row][col] = ++num;
            }

            for (int j = 0; j < size - 1; j++) {
                arr[row][--col] = ++num;
            }

            for (int j = 0; j < size - 2; j++) {
                arr[--row][col] = ++num;
            }

            size = size - 2;
        }

        return arr;
    }
}
