/*
https://leetcode.com/problems/find-all-anagrams-in-a-string/

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
The order of output does not matter.

Example 1:
Input: s: "cbaebabacd" p: "abc"
Output: [0, 6]

Example 2:
Input: s: "abab" p: "ab"
Output: [0, 1, 2]
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> out = new ArrayList<>();
        if (s.length() < p.length()) {
            return out;
        }

        Map<Character, Integer> pCharMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pCharMap.put(c, pCharMap.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        int end = start + p.length() - 1;
        Map<Character, Integer> sCharMap = new HashMap<>();
        for (int i = start; i <= end; i++) {
            sCharMap.put(s.charAt(i), sCharMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        if (sCharMap.equals(pCharMap)) {
            out.add(start);
        }

        while (end < s.length() - 1) {
            end++;
            sCharMap.put(s.charAt(end), sCharMap.getOrDefault(s.charAt(end), 0) + 1);

            sCharMap.put(s.charAt(start), sCharMap.get(s.charAt(start)) - 1);
            if (sCharMap.get(s.charAt(start)) == 0) {
                sCharMap.remove(s.charAt(start));
            }
            start++;

            if (sCharMap.equals(pCharMap)) {
                out.add(start);
            }
        }

        return out;
    }
}
