/*
https://leetcode.com/problems/maximum-product-of-three-numbers/

Given an integer array, find three numbers whose product is maximum and output the maximum product.

Example 1:
Input: [1,2,3]
Output: 6

Example 2:
Input: [1,2,3,4]
Output: 24
*/

class Solution {
    public int maximumProduct(int[] nums) {
        int min1, min2, max1, max2, max3;
        min1 = min2 = Integer.MAX_VALUE;
        max1 = max2 = max3 = Integer.MIN_VALUE;

        for (int i : nums) {
            if (i <= min1) {
                min2 = min1;
                min1 = i;
            } else if (i <= min2) {
                min2 = i;
            }

            if (i >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = i;
            } else if (i >= max2) {
                max3 = max2;
                max2 = i;
            } else if (i >= max3) {
                max3 = i;
            }
        }

        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}
