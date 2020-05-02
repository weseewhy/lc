/*
https://leetcode.com/problems/n-th-tribonacci-number/

The Tribonacci sequence Tn is defined as follows: 
T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
Given n, return the value of Tn.

Example 1:
Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4

Example 2:
Input: n = 25
Output: 1389537
*/

class Solution {
    public int tribonacci(int n) {
        if (n <= 1) {
            return n;
        } else if (n == 2) {
            return 1;
        }

        int tnMinus3 = 0;
        int tnMinus2 = 1;
        int tnMinus1 = 1;

        int t = 0;
        for (int i = 3; i <= n; i++) {
            t = tnMinus1 + tnMinus2 + tnMinus3;
            tnMinus3 = tnMinus2;
            tnMinus2 = tnMinus1;
            tnMinus1 = t;
        }

        return t;
    }
}
