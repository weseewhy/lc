/*
https://leetcode.com/problems/range-sum-query-immutable/

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]
sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3

Note:
You may assume that the array does not change.
There are many calls to sumRange function.
*/

class NumArray {
    private int[] cache;

    public NumArray(int[] nums) {
        cache = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum += nums[i];
            cache[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        return i == 0 ? cache[j] : cache[j] - cache[i - 1];
    }
}
