/*
https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/

Given an array of numbers arr. Return true if the array can be rearranged
to form an arithmetic progression, otherwise, return false.

Example 1:
Input: arr = [3,5,1]
Output: true

Example 2:
Input: arr = [1,2,4]
Output: false

Constraints:
    . 2 <= arr.length <= 1000
    . -10^6 <= arr[i] <= 10^6
*/

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length <= 2) {
            return true;
        }

        int min = Math.min(arr[0], arr[1]);
        int max = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }

        if ((max - min) % (arr.length - 1) != 0) {
            return false;
        } else if (max == min) {
            return true;
        }

        int diff = (max - min) / (arr.length - 1);
        Set<Integer> set = new HashSet<>();
        for (int value : arr) {
            set.add(value);
        }

        int val = min;
        while (val < max) {
            if (!set.contains(val)) {
                return false;
            }
            val += diff;
        }

        return true;
    }
}
