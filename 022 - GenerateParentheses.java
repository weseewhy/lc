/*
https://leetcode.com/problems/generate-parentheses/

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> out = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generate(sb, n, n, out);
        return out;
    }

    private void generate(StringBuilder sb, int openRemaining, int closedRemaining, List<String> out) {
        if (openRemaining < 0 || closedRemaining < openRemaining) {
            return;
        }

        if (closedRemaining == 0) {
            out.add(sb.toString());
        } else {
            sb.append("(");
            generate(sb, openRemaining - 1, closedRemaining, out);
            sb.deleteCharAt(sb.length() - 1);

            sb.append(")");
            generate(sb, openRemaining, closedRemaining - 1, out);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
