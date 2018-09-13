/*
https://leetcode.com/problems/two-sum/

Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> elemAndIndex = new HashMap<>();
        int out[] = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int desired = target - cur;
            if (elemAndIndex.containsKey(desired)) {
                out[1] = i;
                out[0] = elemAndIndex.get(desired);
                break;
            } else {
                elemAndIndex.put(cur, i);
            }
        }

        return out;
    }
}
