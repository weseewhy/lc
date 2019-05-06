/*
https://leetcode.com/problems/search-in-rotated-sorted-array/

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
You are given a target value to search. If found in the array return its index, otherwise return -1.
You may assume no duplicate exists in the array.
Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
*/

class Solution {
    public int search(int[] nums, int target) {
        return rotatedSearch(nums, 0, nums.length - 1, target);
    }

    private int rotatedSearch(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        // Left is increasing
        if (nums[start] <= nums[mid]) {
            if (nums[start] <= target && target < nums[mid]) {
                // target can be in left increasing seq
                return binarySearch(nums, start, mid - 1, target);
            } else {
                return rotatedSearch(nums, mid + 1, end, target);
            }
        } else { // Right is increasing
            if (nums[mid] < target && target <= nums[end]) {
                // target can be in right increasing seq
                return binarySearch(nums, mid + 1, end, target);
            } else {
                return rotatedSearch(nums, start, mid - 1, target);
            }
        }
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end || target < nums[start] || target > nums[end]) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return binarySearch(nums, start, mid - 1, target);
        } else {
            return binarySearch(nums, mid + 1, end, target);
        }
    }
}
