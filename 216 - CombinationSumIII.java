/*
https://leetcode.com/problems/combination-sum-iii/

Find all possible combinations of k numbers that add up to a number n,
given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Example 1:
Input: k = 3, n = 7
Output: [[1,2,4]]

Example 2:
Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        traverse(1, k, n, cur, out);
        return out;
    }

    private void traverse(int i, int k, int n, List<Integer> cur, List<List<Integer>> out) {
        if (k == 0 && n == 0) {
            out.add(new ArrayList<>(cur));
            return;
        } else if (n <= 0 || k <= 0) {
            return;
        }

        for (int j = i; j <= 9; j++) {
            cur.add(j);
            traverse(j + 1, k - 1, n - j, cur, out);
            cur.remove(cur.size() - 1);
        }
    }
}
