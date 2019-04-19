/*
https://leetcode.com/problems/ugly-number-ii/

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
Write a program to find the n-th ugly number.

Example:
Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note:
  - 1 is typically treated as an ugly number.
  - n does not exceed 1690.
*/

class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int[] arr = new int[n];
        arr[0] = 1;
        int i2, i3, i5, val2, val3, val5;
        i2 = i3 = i5 = 0;
        val2 = 2;
        val3 = 3;
        val5 = 5;

        for (int i = 1; i < n; i++) {
            int minVal = Math.min(val2, Math.min(val3, val5));
            arr[i] = minVal;

            if (minVal == val2) {
                i2++;
                val2 = arr[i2] * 2;
            }

            if (minVal == val3) {
                i3++;
                val3 = arr[i3] * 3;
            }

            if (minVal == val5) {
                i5++;
                val5 = arr[i5] * 5;
            }
        }

        return arr[n - 1];
    }
}
