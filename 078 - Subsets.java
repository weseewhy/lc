/*
https://leetcode.com/problems/subsets/

Given a set of distinct integers, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.

Example:
Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    /**************** USING BITS ****************/
    public List<List<Integer>> subsets_usingBits(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        out.add(new ArrayList<>());
        int cnt = (int) Math.pow(2, nums.length);

        for (int i = 1; i < cnt; i++) {
            List<Integer> subset = new ArrayList<>();
            out.add(subset);

            int mask = cnt >> 1;
            for (int val : nums) {
                if ((i & mask) != 0) {
                    subset.add(val);
                }
                mask = mask >> 1;
            }
        }

        return out;
    }

    /**************** BACK TRACKING ****************/
    public List<List<Integer>> subsets_Recursive(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), out);
        return out;
    }

    private void dfs(int[] nums, int start, List<Integer> buffer, List<List<Integer>> out) {
        out.add(new ArrayList<>(buffer));

        for (int i = start; i < nums.length; i++) {
            buffer.add(nums[i]);
            dfs(nums, i + 1, buffer, out);
            buffer.remove(buffer.size() - 1);
        }
    }
}
