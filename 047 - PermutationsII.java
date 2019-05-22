/*
https://leetcode.com/problems/permutations-ii/

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:
Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<List<Integer>> permuteUnique(int[] input) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : input) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }

        List<Integer> nums = new ArrayList<>(countMap.keySet());
        List<Integer> cnts = new ArrayList<>(nums.size());
        for (int i : nums) {
            cnts.add(countMap.get(i));
        }

        List<List<Integer>> out = new ArrayList<>();
        int[] buff = new int[input.length];
        helper(nums, cnts, 0, buff, out);
        return out;
    }

    private void helper(List<Integer> nums, List<Integer> cnts, int index, int[] buff, List<List<Integer>> out) {
        if (index == buff.length) {
            out.add(Arrays.stream(buff).boxed().collect(Collectors.toList()));
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            if (cnts.get(i) == 0) continue;

            buff[index] = nums.get(i);
            cnts.set(i, cnts.get(i) - 1);

            helper(nums, cnts, index + 1, buff, out);

            cnts.set(i, cnts.get(i) + 1);
        }
    }
}
