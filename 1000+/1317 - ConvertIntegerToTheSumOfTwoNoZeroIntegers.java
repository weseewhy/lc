/*
https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/

Given an integer n. No-Zero integer is a positive integer which doesn't contain any 0 in its decimal representation.
Return a list of two integers [A, B] where:
    . A and B are No-Zero integers.
    . A + B = n
It's guaranteed that there is at least one valid solution. If there are many valid solutions you can return any of them.

Example 1:
Input: n = 2
Output: [1,1]

Example 2:
Input: n = 11
Output: [2,9]

Example 3:
Input: n = 10000
Output: [1,9999]

Example 4:
Input: n = 69
Output: [1,68]

Example 5:
Input: n = 1010
Output: [11,999]
*/

class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] out = new int[2];
        for (int i = 1; i <= n / 2; i++) {
            if (isNonZero(i) && isNonZero(n - i)) {
                return new int[]{i, n - i};
            }
        }
        return new int[]{-1, -1};
    }

    private boolean isNonZero(int val) {
        while (val > 0) {
            if (val % 10 == 0) {
                return false;
            }
            val = val / 10;
        }
        return true;
    }
}
