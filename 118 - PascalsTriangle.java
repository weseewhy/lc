/*
https://leetcode.com/problems/pascals-triangle/

Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example: 
Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> out = new ArrayList<>();
        if (numRows <= 0) {
            return out;
        }
        out.add(Collections.singletonList(1));
        List<Integer> row;
        List<Integer> prev = out.get(0);
        for (int i = 2; i <= numRows; i++) {
            row = new ArrayList<>(i);
            row.add(1);
            for (int j = 1; j <= i - 2; j++) {
                row.add(j, prev.get(j) + prev.get(j - 1));
            }
            row.add(1);
            out.add(row);
            prev = row;
        }

        return out;
    }
}
