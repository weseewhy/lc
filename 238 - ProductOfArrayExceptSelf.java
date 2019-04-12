/*
https://leetcode.com/problems/product-of-array-except-self/

Given an array nums of n integers where n > 1,  return an array output such that
output[i] is equal to the product of all the elements of nums except nums[i].

Example:
Input:  [1,2,3,4]
Output: [24,12,8,6]

Note: Please solve it without division and in O(n) time and O(1) space.
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] out = new int[nums.length];

        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            out[i] = left;
            if (i != nums.length - 1) {
                left *= nums[i];
            }
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            out[i] *= right;
            if (i != 0) {
                right *= nums[i];
            }
        }

        return out;
    }
}
