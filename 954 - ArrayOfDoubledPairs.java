/*
https://leetcode.com/problems/array-of-doubled-pairs/

Given an array of integers A with even length, return true if and only if it is possible to reorder 
it such that A[2 * i + 1] = 2 * A[2 * i] for every 0 <= i < len(A) / 2.

Example 1:
Input: [3,1,3,6]
Output: false

Example 2:
Input: [2,1,2,6]
Output: false

Example 3:
Input: [4,-2,2,-4]
Output: true
Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].

Example 4:
Input: [1,2,4,16,8,4]
Output: false
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canReorderDoubled(int[] A) {
        Arrays.sort(A);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : A) {
            if (map.getOrDefault(i, 0) > 0) {
                int other;
                if (i < 0) {
                    if (i % 2 != 0) {
                        return false;
                    }
                    other = i / 2;
                } else {
                    other = 2 * i;
                }

                int cnt = map.getOrDefault(other, 0);
                if (cnt == 0) {
                    return false;
                }

                map.put(other, cnt - 1);
                map.put(i, map.get(i) - 1);
            }
        }

        return true;
    }
}
