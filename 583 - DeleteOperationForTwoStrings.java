/*
https://leetcode.com/problems/delete-operation-for-two-strings/

Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same,
where in each step you can delete one character in either string.

Example 1:
Input: "sea", "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
*/

class Solution {
    public int minDistance(String word1, String word2) {
        int lcs = lcs(word1, word2);
        return (word1.length() - lcs) + (word2.length() - lcs);
    }

    private int lcs(String a, String b) {
        int[][] cache = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    cache[i][j] = cache[i - 1][j - 1] + 1;
                } else {
                    cache[i][j] = Math.max(cache[i - 1][j], cache[i][j - 1]);
                }
            }
        }

        return cache[a.length()][b.length()];
    }
}
