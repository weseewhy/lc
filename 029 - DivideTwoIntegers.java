/*
https://leetcode.com/problems/divide-two-integers/

Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
Return the quotient after dividing dividend by divisor.
The integer division should truncate toward zero.

Example 1:
Input: dividend = 10, divisor = 3
Output: 3

Example 2:
Input: dividend = 7, divisor = -3
Output: -2

Note:
Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
*/

class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = dividend < 0 ^ divisor < 0;
        // Convert them to longs before getting abs
        // Because Math.abs(Integer.MIN_VALUE) returns Integer.MIN_VALUE
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);
        int out = 0;

        while (lDividend >= lDivisor) {
            long dvsr = lDivisor;
            int times = 1;
            while (dvsr << 1 <= lDividend) {
                dvsr = dvsr << 1;
                times = times << 1;
            }

            lDividend -= dvsr;
            out += times;
        }

        return isNegative ? -out : out;
    }
}