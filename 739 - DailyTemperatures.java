/*
https://leetcode.com/problems/daily-temperatures/

Given a list of daily temperatures T, return a list such that, for each day in the input, 
tells you how many days you would have to wait until a warmer temperature. 
If there is no future day for which this is possible, put 0 instead.

Example:
Input: [73, 74, 75, 71, 69, 72, 76, 73], 
Output: [1, 1, 4, 2, 1, 1, 0, 0].
*/

import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] out = new int[T.length];
        if (T.length == 0) {
            return out;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int index = stack.pop();
                out[index] = i - index;
            }

            stack.push(i);
        }

        return out;
    }
}
