/*
https://leetcode.com/problems/score-of-parentheses/

Given a balanced parentheses string S, compute the score of the string based on the following rule:
() has score 1
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
 

Example 1:
Input: "()"
Output: 1

Example 2:
Input: "(())"
Output: 2

Example 3:
Input: "()()"
Output: 2

Example 4:
Input: "(()(()))"
Output: 6
*/

import java.util.Stack;

class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            push(c == '(' ? 0 : -1, stack);
        }

        return stack.pop();
    }

    private void push(int c, Stack<Integer> stack) {
        if (c < 0) {
            int top = stack.pop();
            if (top == 0) {
                push(1, stack);
            } else {
                stack.pop();
                push(2 * top, stack);
            }
        } else if (c > 0 && !stack.isEmpty() && stack.peek() > 0) {
            push(c + stack.pop(), stack);
        } else {
            stack.push(c);
        }
    }
}
