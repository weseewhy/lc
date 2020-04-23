/*
https://leetcode.com/problems/lucky-numbers-in-a-matrix/

Given a m * n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

Example 1:
Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column

Example 2:
Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.

Example 3:
Input: matrix = [[7,8],[1,2]]
Output: [7]
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int[] colMax = new int[matrix[0].length];

        Set<Integer> mins = new HashSet<>();
        for (int row = 0; row < matrix.length; row++) {
            int min = matrix[row][0];
            for (int col = 0; col < matrix[0].length; col++) {
                min = Math.min(min, matrix[row][col]);
                colMax[col] = Math.max(colMax[col], matrix[row][col]);
            }
            mins.add(min);
        }

        List<Integer> out = new ArrayList<>();
        for (int val : colMax) {
            if (mins.contains(val)) {
                out.add(val);
            }
        }

        return out;
    }
}
