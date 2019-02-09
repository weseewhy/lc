/*
Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

Example 1:
Input: [4,2,3]
Output: True
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.

Example 2:
Input: [4,2,1]
Output: False
Explanation: You can't get a non-decreasing array by modify at most one element.
*/

class Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums.length <= 2) {
            return true;
        }

        // Find problem index i such that nums[i-1] < nums[i] > nums[i+1]
        // Handle case when nums[i-1] < nums[i+1] and nums[i-1] > nums[i+1]
        boolean corrected = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (corrected) {
                    return false;
                }
                corrected = true;

                if (i > 0) {
                    if (nums[i - 1] <= nums[i + 1]) {
                        nums[i] = nums[i - 1];
                    } else {
                        nums[i + 1] = nums[i];
                    }
                }
            }
        }

        return true;
    }
}
