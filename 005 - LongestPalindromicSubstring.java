/*
https://leetcode.com/problems/longest-palindromic-substring/

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:
Input: "cbbd"
Output: "bb"
*/

class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int maxLength = 1;
        int pStart = 0;
        int pEnd = 0;
        int curLength;
        for (int i = 0; i < s.length(); i++) {
            curLength = palindromeWithGivenCenter(s, i, i);
            if (curLength > maxLength) {
                int sideLengthExcludingCenter = (curLength - 1) / 2;
                pStart = i - sideLengthExcludingCenter;
                pEnd = i + sideLengthExcludingCenter;
                maxLength = curLength;
            }

            curLength = palindromeWithGivenCenter(s, i, i + 1);
            if (curLength > maxLength) {
                int sideLengthExcludingCenter = (curLength - 2) / 2;
                pStart = i - sideLengthExcludingCenter;
                pEnd = (i + 1) + sideLengthExcludingCenter;
                maxLength = curLength;
            }
        }

        return s.substring(pStart, pEnd + 1);
    }

    // Find longest substring with substring[start,end] as center
    private int palindromeWithGivenCenter(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }

        return end - start - 1;
    }
}
