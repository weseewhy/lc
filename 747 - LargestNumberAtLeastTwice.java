/*
https://leetcode.com/problems/largest-number-at-least-twice-of-others/description/

In a given integer array nums, there is always exactly one largest element.
Find whether the largest element in the array is at least twice as much as every other number in the array.
If it is, return the index of the largest element, otherwise return -1.

Example 1:
Input: nums = [3, 6, 1, 0]
Output: 1
Explanation: 6 is the largest integer, and for every other number in the array x,
6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
 
Example 2:
Input: nums = [1, 2, 3, 4]
Output: -1
Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
*/
public class LargestNumberAtLeastTwice {

    public int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int largest = nums[0];
        int lIndex = 0;
        int secondLargest = -1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > largest) {
                secondLargest = largest;
                largest = nums[i];
                lIndex = i;
            } else if (nums[i] > secondLargest) {
                secondLargest = nums[i];
            }
        }

        return largest >= 2 * secondLargest ? lIndex : -1;
    }
}
