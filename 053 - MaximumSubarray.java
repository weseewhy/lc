/*
https://leetcode.com/problems/maximum-subarray/

Given an integer array nums, find the contiguous subarray (containing at least one number)
which has the largest sum and return its sum.

Example:
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
*/
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int curSum = nums[0];
        int maxSum = curSum;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            curSum = Math.max(cur, curSum + cur);
            maxSum = Math.max(curSum, maxSum);
        }

        return maxSum;
    }
}
