/*
https://leetcode.com/problems/pascals-triangle-ii/

Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
Note that the row index starts from 0.

Example:
Input: 3
Output: [1,3,3,1]

Follow up:
Could you optimize your algorithm to use only O(k) extra space?
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int k) {
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            row.add(1);
            for (int j = row.size() - 2; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }

        return row;
    }
}
