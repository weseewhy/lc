/*
https://leetcode.com/problems/verifying-an-alien-dictionary/

In an alien language, surprisingly they also use english lowercase letters, 
but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, 
return true if and only if the given words are sorted lexicographicaly in this alien language.

Example 1:
Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.

Example 2:
Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.

Example 3:
Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size)
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        for (int i = 1; i < words.length; i++) {
            if (!isLexicographic(words[i - 1], words[i], orderMap)) {
                return false;
            }
        }

        return true;
    }

    private boolean isLexicographic(String s1, String s2, Map<Character, Integer> order) {
        int len = Math.min(s1.length(), s2.length());
        for (int i = 0; i < len; i++) {
            int o1 = order.get(s1.charAt(i));
            int o2 = order.get(s2.charAt(i));

            if (o1 < o2) {
                return true;
            } else if (o1 > o2) {
                return false;
            }
        }

        return s1.length() <= s2.length();
    }
}
