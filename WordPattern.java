/*
https://leetcode.com/problems/word-pattern/

Given a pattern and a string str, find if str follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:
Input: pattern = "abba", str = "dog cat cat dog"
Output: true

Example 2:
Input:pattern = "abba", str = "dog cat cat fish"
Output: false

Example 3:
Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false

Example 4:
Input: pattern = "abba", str = "dog dog dog dog"
Output: false
*/

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> charMap = new HashMap<>();
        Map<String, Character> wordMap = new HashMap<>();
        String[] split = str.split("\\s+");
        if (split.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = split[i];

            if (!charMap.containsKey(c) && !wordMap.containsKey(w)) {
                charMap.put(c, w);
                wordMap.put(w, c);
            } else if ((charMap.containsKey(c) && !wordMap.containsKey(w)) ||
                    (wordMap.containsKey(w) && !charMap.containsKey(c)) ||
                    !charMap.get(c).equals(w) || !wordMap.get(w).equals(c)) {
                return false;
            }
        }

        return true;
    }
}
