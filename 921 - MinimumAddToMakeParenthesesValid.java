/*
https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')',
and in any positions ) so that the resulting parentheses string is valid.

Formally, a parentheses string is valid if and only if:
  - It is the empty string, or
  - It can be written as AB (A concatenated with B), where A and B are valid strings, or
  - It can be written as (A), where A is a valid string.
  - Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.

Example 1:
Input: "())"
Output: 1

Example 2:
Input: "((("
Output: 3

Example 3:
Input: "()"
Output: 0

Example 4:
Input: "()))(("
Output: 4
*/

class Solution {
    public int minAddToMakeValid(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }

        int changes = 0;
        int cnt = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') {
                cnt++;
            } else {
                if (cnt > 0) {
                    cnt--;
                } else {
                    changes++;
                }
            }
        }

        return changes + cnt;
    }
}
