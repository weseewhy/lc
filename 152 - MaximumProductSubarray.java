/*
https://leetcode.com/problems/maximum-product-subarray/

Given an integer array nums, find the contiguous subarray within an array
(containing at least one number) which has the largest product.

Example 1:
Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/

class Solution {
    public int maxProduct(int[] nums) {
        // Holds the global max
        int res = nums[0];

        // Holds the min/max of subarray ending at index i
        int min, max;
        min = max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // If the current number is negative, min and max will be reversed (because of -ve sign)
            if (nums[i] < 0) {
                int temp = min;
                min = max;
                max = temp;
            }

            // min/max can be just the current number or
            // the number obtained after multiplying result from previous subarray
            min = Math.min(nums[i], min * nums[i]);
            max = Math.max(nums[i], max * nums[i]);

            // Update global max seen so far
            res = Math.max(res, max);
        }

        return res;
    }
}
