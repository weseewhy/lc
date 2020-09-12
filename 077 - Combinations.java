/*
https://leetcode.com/problems/combinations/

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
You may return the answer in any order.

Example 1:
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

Example 2:
Input: n = 1, k = 1
Output: [[1]]

Constraints:
    . 1 <= n <= 20
    . 1 <= k <= n
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> out = new ArrayList<>();
        helper(1, n, k, new ArrayList<>(), out);
        return out;
    }

    private void helper(int start, int end, int k, ArrayList<Integer> path, List<List<Integer>> out) {
        if (k == 0) {
            out.add(new ArrayList<>(path));
            return;
        }

        // To have atleast a window of size k
        int maxStart = end - k + 1;

        while (start <= maxStart) {
            path.add(start);
            helper(start + 1, end, k - 1, path, out);
            path.remove(path.size() - 1);
            start++;
        }
    }
}
