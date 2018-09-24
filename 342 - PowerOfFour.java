/*
https://leetcode.com/problems/power-of-four/

Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
*/

class Solution {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }

        while (num > 1) {
            if (num % 4 != 0) {
                return false;
            }
            num = num / 4;
        }

        return true;
    }
}
