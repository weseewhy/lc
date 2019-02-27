/*
https://leetcode.com/problems/integer-replacement/

Given a positive integer n and you can do operations as follow:
   - If n is even, replace n with n/2.
   - If n is odd, you can replace n with either n + 1 or n - 1.

What is the minimum number of replacements needed for n to become 1?

Example 1:
Input: 8
Output: 3
Explanation: 8 -> 4 -> 2 -> 1

Example 2:
Input: 7
Output: 4
Explanation: 7 -> 8 -> 4 -> 2 -> 1  or  7 -> 6 -> 3 -> 2 -> 1
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int integerReplacement(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        return integerReplacement(n, map);
    }

    private int integerReplacement(int n, Map<Integer, Integer> map) {
        if (!map.containsKey(n)) {
            int cnt;
            if (n % 2 == 0) {
                cnt = integerReplacement(n / 2, map);
            } else if (n == Integer.MAX_VALUE) {
                cnt = integerReplacement(n - 1, map);
            } else {
                cnt = Math.min(integerReplacement(n + 1, map), integerReplacement(n - 1, map));
            }

            map.put(n, cnt + 1);
        }

        return map.get(n);
    }
}
