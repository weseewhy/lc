/*
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:
Input: [3,4,5,1,2]
Output: 1

Example 2:
Input: [4,5,6,7,0,1,2]
Output: 0
*/

class Solution {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int left, int right) {
        if (left == right || nums[left] < nums[right]) {
            return nums[left];
        } else if (right - left == 1) {
            return Math.min(nums[left], nums[right]);
        } else {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                return nums[mid];
            }

            if (nums[left] < nums[mid]) {
                return findMin(nums, mid + 1, right);
            } else {
                return findMin(nums, left, mid - 1);
            }
        }
    }
}
