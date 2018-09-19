/*
https://leetcode.com/problems/buddy-strings/

Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.

Example 1:
Input: A = "ab", B = "ba"
Output: true

Example 2:
Input: A = "ab", B = "ab"
Output: false

Example 3:
Input: A = "aa", B = "aa"
Output: true

Example 4:
Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true

Example 5:
Input: A = "", B = "aa"
Output: false
*/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean buddyStrings(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        } else if (a.equals(b)) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < a.length(); i++) {
                if (set.contains(a.charAt(i))) {
                    return true;
                }
                set.add(a.charAt(i));
            }
        }

        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        int prevIndex = -1;
        boolean swapped = false;
        for (int i = 0; i < ac.length; i++) {
            if (ac[i] != bc[i]) {
                if (swapped) {
                    return false;
                } else if (prevIndex == -1) {
                    prevIndex = i;
                } else {
                    swapped = true;
                    if (ac[prevIndex] != bc[i] || ac[i] != bc[prevIndex]) {
                        return false;
                    }
                }
            }
        }

        return swapped;
    }
}
