/*
https://leetcode.com/problems/powerful-integers/

Given two non-negative integers x and y, an integer is powerful if it is equal to x^i + y^j for some integers i >= 0 and j >= 0.
Return a list of all powerful integers that have value less than or equal to bound.
You may return the answer in any order.  In your answer, each value should occur at most once.

Example 1:
Input: x = 2, y = 3, bound = 10
Output: [2,3,4,5,7,9,10]
Explanation: 
2 = 2^0 + 3^0
3 = 2^1 + 3^0
4 = 2^0 + 3^1
5 = 2^1 + 3^1
7 = 2^2 + 3^1
9 = 2^3 + 3^0
10 = 2^0 + 3^2

Example 2:
Input: x = 3, y = 5, bound = 15
Output: [2,4,6,8,10,14]
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 32 && Math.pow(x, i) < bound; i++) {
            for (int j = 0; j < 32 && j < Math.pow(y, j); j++) {
                int powerfulInt = powerfulInt(x, i, y, j);
                if (powerfulInt <= bound) {
                    set.add(powerfulInt);
                } else {
                    break;
                }
            }
        }

        return new ArrayList<>(set);
    }

    private int powerfulInt(int x, int powerX, int y, int powerY) {
        return (int) (Math.pow(x, powerX) + Math.pow(y, powerY));
    }
}
