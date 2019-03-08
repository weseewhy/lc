/*
https://leetcode.com/problems/letter-case-permutation/

Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]

Note:
 - S will be a string with length between 1 and 12.
 - S will consist only of letters or digits.
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    // Only works if length of string < 32
    public List<String> letterCasePermutation_BITS(String S) {
        int charCnt = 0;
        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(S.charAt(i))) {
                charCnt++;
            }
        }

        int totalCombinations = 1 << charCnt;
        List<String> out = new ArrayList<>(totalCombinations);
        for (int i = 0; i < totalCombinations; i++) {
            StringBuilder sb = new StringBuilder(S.length());
            int flag = 1;
            for (int j = S.length() - 1; j >= 0; j--) {
                char c = S.charAt(j);
                if (!Character.isLetter(c)) {
                    sb.append(c);
                } else {
                    boolean flip = (i & flag) != 0;
                    sb.append(!flip ? c : Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.toLowerCase(c));
                    flag = flag << 1;
                }
            }

            out.add(sb.reverse().toString());
        }

        return out;
    }

    public List<String> letterCasePermutation_DFS(String S) {
        List<String> out = new ArrayList<>();
        letterCasePermutation_DFS(S.toCharArray(), 0, out);
        return out;
    }

    private void letterCasePermutation_DFS(char[] c, int i, List<String> out) {
        if (i == c.length) {
            out.add(new String(c));
            return;
        }

        if (!Character.isLetter(c[i])) {
            letterCasePermutation_DFS(c, i + 1, out);
            return;
        }

        c[i] = Character.toLowerCase(c[i]);
        letterCasePermutation_DFS(c, i + 1, out);

        c[i] = Character.toUpperCase(c[i]);
        letterCasePermutation_DFS(c, i + 1, out);
    }
}
