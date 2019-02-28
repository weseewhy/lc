/*
https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/

Given a string and a string dictionary, find the longest string in the dictionary that can be formed 
by deleting some characters of the given string. If there are more than one possible results, 
return the longest word with the smallest lexicographical order. 
If there is no possible result, return the empty string.

Example 1:
Input: s = "abpcplea", d = ["ale","apple","monkey","plea"]
Output: "apple"

Example 2:
Input: s = "abpcplea", d = ["a","b","c"]
Output: "a"
*/

import java.util.List;

class Solution {
    public String findLongestWord(String s, List<String> d) {
        String out = "";

        for (String word : d) {
            if (match(s, word)) {
                if (out.length() == 0 || word.length() > out.length() ||
                        (word.length() == out.length() && word.compareTo(out) < 0)) {
                    out = word;
                }
            }
        }

        return out;
    }

    private boolean match(String original, String desired) {
        if (desired.length() > original.length()) {
            return false;
        }

        int i = 0;
        int j = 0;

        while (i < original.length() && j < desired.length()) {
            if (original.charAt(i) == desired.charAt(j)) {
                j++;
            }
            i++;
        }

        return j == desired.length();
    }
}
