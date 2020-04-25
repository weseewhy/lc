/*
https://leetcode.com/problems/check-if-n-and-its-double-exist/

Given an array arr of integers, check if there exists two integers N and M 
such that N is the double of M ( i.e. N = 2 * M).

Example 1:
Input: arr = [10,2,5,3]
Output: true

Example 2:
Input: arr = [7,1,14,11]
Output: true

Example 3:
Input: arr = [3,1,7,11]
Output: false
*/

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int val : arr) {
            if (set.contains(val * 2)) {
                return true;
            }
            if (val % 2 == 0 && set.contains(val / 2)) {
                return true;
            }

            set.add(val);
        }
        return false;
    }
}
