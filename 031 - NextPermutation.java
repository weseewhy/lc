/*
https://leetcode.com/problems/next-permutation/

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
The replacement must be in-place and use only constant extra memory.

EXAMPLES:
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        int targetIndex = -1;
        // Find the first index from end where the value decreases
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                targetIndex = i;
                break;
            }
        }

        if (targetIndex != -1) {
            // From end, find first index whose value is greater than problem index and swap them
            for (int i = nums.length - 1; i > targetIndex; i--) {
                if (nums[i] > nums[targetIndex]) {
                    swap(nums, targetIndex, i);
                    break;
                }
            }
        }

        Arrays.sort(nums, targetIndex + 1, nums.length);
    }

    private void swap(int[] arr, int i, int j) {
        if (i != j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
