/*
https://leetcode.com/problems/longest-increasing-subsequence/

Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:
Input: [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int[] arrLIS = new int[nums.length];
        arrLIS[0] = 1;
        int lenLIS = 1;

        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, arrLIS[j]);
                }
            }

            arrLIS[i] = max + 1;
            lenLIS = Math.max(lenLIS, arrLIS[i]);
        }

        return lenLIS;
    }
}
