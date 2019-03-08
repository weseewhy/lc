/*
https://leetcode.com/problems/combination-sum-ii/

Given a collection of candidate numbers (candidates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sums to target.
Each number in candidates may only be used once in the combination.

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

Example 2:
Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> out = new ArrayList<>();
        Arrays.sort(candidates);
        traverse(candidates, 0, target, new ArrayList<>(), out);
        return out;
    }

    private void traverse(int[] candidates, int index, int target, List<Integer> cur, List<List<Integer>> out) {
        if (target == 0) {
            out.add(new ArrayList<>(cur));
            return;
        } else if (index >= candidates.length || target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // If same as prev val, skip it
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            cur.add(candidates[i]);
            traverse(candidates, i + 1, target - candidates[i], cur, out);
            cur.remove(cur.size() - 1);
        }
    }
}
