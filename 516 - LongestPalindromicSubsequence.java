/*
https://leetcode.com/problems/longest-palindromic-subsequence/

Given a string s, find the longest palindromic subsequence's length in s.

Example 1:
Input: "bbbab"
Output: 4
One possible longest palindromic subsequence is "bbbb".

Example 2:
Input: "cbbd"
Output: 2
One possible longest palindromic subsequence is "bb".
*/

class Solution {
    public int lps(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        int[][] cache = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                cache[i][j] = i == j ? 1 : -1;
            }
        }

        return lps(s, 0, s.length() - 1, cache);
    }

    private int lps(String s, int start, int end, int[][] cache) {
        if (start > end) {
            return 0;
        }

        if (cache[start][end] < 0) {
            if (s.charAt(start) == s.charAt(end)) {
                cache[start][end] = 2 + lps(s, start + 1, end - 1, cache);
            } else {
                cache[start][end] = Math.max(
                        lps(s, start, end - 1, cache),
                        lps(s, start + 1, end, cache)
                );
            }
        }

        return cache[start][end];
    }
}
