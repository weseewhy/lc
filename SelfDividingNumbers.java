/*
https://leetcode.com/problems/self-dividing-numbers/

A self-dividing number is a number that is divisible by every digit it contains.
For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
Also, a self-dividing number is not allowed to contain the digit zero.
Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

Example 1:
Input:
left = 1, right = 22
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
*/

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> out = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i)) {
                out.add(i);
            }
        }

        return out;
    }

    private boolean isSelfDividing(int i) {
        int num = i;
        int rem;

        while (num > 0) {
            rem = num % 10;
            if (rem == 0 || i % rem != 0) {
                return false;
            } else {
                num = num / 10;
            }
        }

        return true;
    }
}
