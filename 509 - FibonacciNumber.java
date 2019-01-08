/*
https://leetcode.com/problems/fibonacci-number/

The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, 
such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
    F(0) = 0,   F(1) = 1
    F(N) = F(N - 1) + F(N - 2), for N > 1.
Given N, calculate F(N).
*/

class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int fn1 = 1;
        int fn2 = 0;
        int fn = -1;

        for (int i = 2; i <= n; i++) {
            fn = fn1 + fn2;
            fn2 = fn1;
            fn1 = fn;
        }

        return fn;
    }
}
