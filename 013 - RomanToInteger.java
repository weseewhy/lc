/*
https://leetcode.com/problems/roman-to-integer/

Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

Example 4:
Input: "LVIII"
Output: 58
Explanation: C = 100, L = 50, XXX = 30 and III = 3.

Example 5:
Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = getRomanMap();
        int val = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i != s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                val -= map.get(s.charAt(i));
            } else {
                val += map.get(s.charAt(i));
            }
        }

        return val;
    }

    private Map<Character, Integer> getRomanMap() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map;
    }
}
