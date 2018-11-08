/*
https://leetcode.com/problems/find-and-replace-pattern/

You have a list of words and a pattern, and you want to know which words in words matches the pattern.
A word matches the pattern if there exists a permutation of letters p so that after replacing every 
letter x in the pattern with p(x), we get the desired word.
(Recall that a permutation of letters is a bijection from letters to letters: 
every letter maps to another letter, and no two letters map to the same letter.)

Return a list of the words in words that match the given pattern. 
You may return the answer in any order.

Example:
Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
since a and b map to the same letter.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> out = new ArrayList<>();
        for (String s : words) {
            if (isMatch(s, pattern)) {
                out.add(s);
            }
        }

        return out;
    }

    private boolean isMatch(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }

        Map<Character, Character> wp = new HashMap<>();
        Map<Character, Character> pw = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);

            if ((wp.containsKey(w) && wp.get(w) != p) || (pw.containsKey(p) && pw.get(p) != w)) {
                return false;
            } else {
                wp.put(w, p);
                pw.put(p, w);
            }
        }

        return true;
    }
}
