/*
https://leetcode.com/problems/longest-palindrome/

Given a string which consists of lowercase or uppercase letters, 
find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Example:
Input: "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
*/

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestPalindrome(String s) {
        int len = 0;
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
            } else {
                len = len + 2;
                set.remove(c);
            }
        }

        if (set.size() > 0) {
            len++;
        }

        return len;
    }
}
