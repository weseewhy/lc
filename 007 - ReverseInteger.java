/*
https://leetcode.com/problems/reverse-integer/

Given a 32-bit signed integer, reverse digits of an integer.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31, 2^31 − 1]. 
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

Example 1:
Input: 123
Output: 321

Example 2:
Input: -123
Output: -321

Example 3:
Input: 120
Output: 21
*/

class Solution {
    public int reverse(int x) {
        int rev = 0;
        boolean negative = x < 0;
        x = Math.abs(x);
        while (x > 0) {
            int nextDigit = x % 10;
            x = x / 10;

            if (rev > Integer.MAX_VALUE / 10) {
                return 0;
            } else if (rev == Integer.MAX_VALUE / 10 && nextDigit > Integer.MAX_VALUE % 10) {
                return 0;
            }

            rev = rev * 10 + nextDigit;
        }

        if (negative) {
            rev = 0 - rev;
        }

        return rev;
    }
}
