/*
https://leetcode.com/problems/rotated-digits/

X is a good number if after rotating each digit individually by 180 degrees,
we get a valid number that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.

A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves;
2 and 5 rotate to each other; 6 and 9 rotate to each other, and the rest of the numbers do not
rotate to any other number and become invalid.

Now given a positive number N, how many numbers X from 1 to N are good?

Example:
Input: 10
Output: 4
Explanation:
There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
*/

import java.util.Arrays;

public class RotatedDigits {
    public int rotatedDigits(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (isGood(i)) {
                cnt++;
            }
        }

        return cnt;
    }

    private boolean isGood(int n) {
        int x = n;
        int y = 0;
        int mul = 1;

        while (x > 0) {
            int rem = x % 10;
            if (!canRotate(rem)) {
                return false;
            }

            y += rotate(rem) * (mul);
            mul = mul * 10;
            x = x / 10;
        }

        return n != y;
    }

    private boolean canRotate(int n) {
        return Arrays.asList(0, 1, 2, 5, 6, 8, 9).contains(n);
    }

    private int rotate(int n) {
        if (n == 2) return 5;
        if (n == 5) return 2;
        if (n == 6) return 9;
        if (n == 9) return 6;
        return n;
    }
}
