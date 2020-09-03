/*
https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/

Given an array nums and an integer target.
Return the maximum number of non-empty non-overlapping sub-arrays 
such that the sum of values in each subarray is equal to target.

Example 1:
Input: nums = [1,1,1,1,1], target = 2
Output: 2
Explanation: There are 2 non-overlapping subarrays [1,1,1,1,1] with sum equals to target(2).

Example 2:
Input: nums = [-1,3,5,1,4,2,-9], target = 6
Output: 2
Explanation: There are 3 subarrays with sum equal to 6.
([5,1], [4,2], [3,5,1,4,2,-9]) but only the first 2 are non-overlapping.

Example 3:
Input: nums = [-2,6,6,3,5,4,1,2,8], target = 10
Output: 3

Example 4:
Input: nums = [0,0,0], target = 0
Output: 3
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        int cnt = 0;
        int sum = 0;
        int lastIntervalEnd = -1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            // prefix sum
            sum += nums[i];
            
            // prefix sum that should exist so that difference b/w
            // that index and current index will be equal to target
            int remaining = sum - target;
            
            // make sure such prefix sum exists and also it's index
            // is after the end of last interval (because no overlapping)
            if (map.containsKey(remaining) && map.get(remaining) > lastIntervalEnd) {
                cnt++;
                lastIntervalEnd = i;
            }
            map.put(sum, i);
        }

        return cnt;
    }
}
