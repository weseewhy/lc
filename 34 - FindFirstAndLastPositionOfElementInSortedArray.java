/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        return searchRange(nums, 0, nums.length - 1, target);
    }

    private int[] searchRange(int[] nums, int left, int right, int target) {
        if (left > right) {
            return new int[]{-1, -1};
        }

        int mid = left + (right - left) / 2;
        if (nums[mid] < target) {
            return searchRange(nums, mid + 1, right, target);
        } else if (nums[mid] > target) {
            return searchRange(nums, left, mid - 1, target);
        } else {
            int l = mid, r = mid;
            int[] lr = searchRange(nums, left, mid - 1, target);
            int[] rr = searchRange(nums, mid + 1, right, target);

            if (lr[1] != -1) l = lr[0];
            if (rr[0] != -1) r = rr[1];

            return new int[]{l, r};
        }
    }
}
