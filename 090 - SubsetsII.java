/*
https://leetcode.com/problems/subsets-ii/

Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.

Example:
Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> buff = new ArrayList<>();
        helper(nums, 0, buff, out);
        return out;
    }

    private void helper(int[] nums, int start, List<Integer> buff, List<List<Integer>> out) {
        out.add(new ArrayList<>(buff));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;

            buff.add(nums[i]);
            helper(nums, i + 1, buff, out);
            buff.remove(buff.size() - 1);
        }
    }
}
