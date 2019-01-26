/*
https://leetcode.com/problems/group-anagrams/

Given an array of strings, group anagrams together.

Example:
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note:
All inputs will be in lowercase.
The order of your output does not matter.

Time Complexity: O(nk) where n is the number of string  and k is the length of longest word
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String s : strs) {
            String key = anagramKey(s);
            if (!anagramMap.containsKey(key)) {
                anagramMap.put(key, new ArrayList<>());
            }

            anagramMap.get(key).add(s);
        }

        return new ArrayList<>(anagramMap.values());
    }

    private String anagramKey(String word) {
        int[] countArray = new int[26];
        for (char c : word.toCharArray()) {
            countArray[c - 'a'] += 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (countArray[i] > 0) {
                sb.append((char) ('a' + i)).append(countArray[i]);
            }
        }

        return sb.toString();
    }
}
