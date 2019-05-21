/*
https://leetcode.com/problems/3sum/

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.
The solution set must not contain duplicate triplets.

Example:
Given array nums = [-1, 0, 1, 2, -1, -4],
A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> out = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                boolean advanceLeft = false;
                boolean advanceRight = false;
                if (sum == target) {
                    out.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    advanceLeft = true;
                    advanceRight = true;
                } else if (sum < target) {
                    advanceLeft = true;
                } else {
                    advanceRight = true;
                }

                if (advanceLeft) {
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                }

                if (advanceRight) {
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
            }
        }

        return out;
    }
}
