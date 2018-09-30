/*
https://leetcode.com/problems/maximum-average-subarray-i/

Given an array consisting of n integers, find the contiguous sub-array of given length k 
that has the maximum average value. And you need to output the maximum average value.

Example 1:
Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
*/

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
        }

        int start = 0;
        int end = k;
        int curSum = maxSum;
        while (end < nums.length) {
            curSum = curSum - nums[start] + nums[end];
            if (curSum > maxSum) {
                maxSum = curSum;
            }

            start++;
            end++;
        }

        return maxSum * 1.0 / k;
    }
}
