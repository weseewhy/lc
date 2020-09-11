/*
https://leetcode.com/problems/break-a-palindrome/

Given a palindromic string palindrome, replace exactly one character by any lowercase English letter 
so that the string becomes the lexicographically smallest possible string that isn't a palindrome.
After doing so, return the final string.  If there is no way to do so, return the empty string.

Example 1:
Input: palindrome = "abccba"
Output: "aaccba"

Example 2:
Input: palindrome = "a"
Output: ""

Example 3:
Input: palindrome = "aabaa"
Output: "aabab"

Constraints:
    . 1 <= palindrome.length <= 1000
    . palindrome consists of only lowercase English letters.
*/

class Solution {
    public String breakPalindrome(String s) {
        if (s.length() == 1) {
            return "";
        }

        char[] c = s.toCharArray();
        boolean found = false;
        for (int i = 0; i < c.length / 2; i++) {
            if (c[i] != 'a') {
                c[i] = 'a';
                found = true;
                break;
            }
        }

        if (!found) {
            c[c.length - 1] = 'b';
        }

        return new String(c);
    }
}
