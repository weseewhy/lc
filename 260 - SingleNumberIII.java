/*
https://leetcode.com/problems/single-number-iii/

Given an array of numbers nums, in which exactly two elements appear only once 
and all the other elements appear exactly twice. Find the two elements that appear only once.

Example:
Input:  [1,2,1,3,2,5]
Output: [3,5]
*/

class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i : nums) {
            xor ^= i;
        }

        //
        int diffAt = 1;
        while ((xor & diffAt) == 0) {
            diffAt = diffAt << 1;
        }

        int xor1 = 0;
        int xor2 = 0;
        for (int i : nums) {
            if ((i & diffAt) == 0) {
                xor1 ^= i;
            } else {
                xor2 ^= i;
            }
        }

        return new int[]{xor1, xor2};
    }
}
