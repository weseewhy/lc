/*
https://leetcode.com/problems/string-matching-in-an-array/

Given an array of string words. Return all strings in words which is substring of another word in any order. 
String words[i] is substring of words[j], if can be obtained removing some characters to left and/or right side of words[j].

Example 1:
Input: words = ["mass","as","hero","superhero"]
Output: ["as","hero"]
Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
["hero","as"] is also a valid answer.

Example 2:
Input: words = ["leetcode","et","code"]
Output: ["et","code"]
Explanation: "et", "code" are substring of "leetcode".

Example 3:
Input: words = ["blue","green","bu"]
Output: []

Constraints:
    . 1 <= words.length <= 100
    . 1 <= words[i].length <= 30
    . words[i] contains only lowercase English letters.
    . It's guaranteed that words[i] will be unique.
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> stringMatching(String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append("|");
        }

        List<String> out = new ArrayList<>();
        for (String word : words) {
            int firstMatch = sb.indexOf(word);
            if (firstMatch != -1) {
                int lastMatch = sb.lastIndexOf(word);
                // Make sure it's not the same word
                if (firstMatch != lastMatch) {
                    out.add(word);
                }
            }
        }

        return out;
    }
}
