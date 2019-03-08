/*
https://leetcode.com/problems/combination-sum/

Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), 
find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:
  - All numbers (including target) will be positive integers.
  - The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]

Example 2:
Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> out = new ArrayList<>();
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

        cur.add(candidates[index]);
        traverse(candidates, index, target - candidates[index], cur, out);
        cur.remove(cur.size() - 1);

        traverse(candidates, index + 1, target, cur, out);
    }
}
