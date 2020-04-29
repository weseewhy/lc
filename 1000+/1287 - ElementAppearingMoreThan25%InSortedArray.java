/*
https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/

Given an integer array sorted in non-decreasing order, there is exactly one integer 
in the array that occurs more than 25% of the time. Return that integer.

Example 1:
Input: arr = [1,2,2,6,6,6,6,7,10]
Output: 6
*/

class Solution {
    public int findSpecialInteger(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[i + arr.length / 4]) {
                return arr[i];
            }
        }
        return -1;
    }
}
