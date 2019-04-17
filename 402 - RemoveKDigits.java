/*
https://leetcode.com/problems/remove-k-digits/

Given a non-negative integer num represented as a string,
remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.

Example 1:
Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:
Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Example 3:
Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
*/

import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        String smallestNum = helper(num, k);
        return removeLeadingZeroes(smallestNum);
    }

    private String removeLeadingZeroes(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }

        return i == s.length() ? "0" : s.substring(i);
    }

    private String helper(String s, int k) {
        if (k == 0) {
            return s;
        } else if (k == s.length()) {
            return "";
        }

        int bestFirstDigitIndex = 0;
        int min = s.charAt(0) - '0';
        for (int i = 1; i <= k; i++) {
            if ((s.charAt(i) - '0') < min) {
                bestFirstDigitIndex = i;
                min = s.charAt(i) - '0';
            }
        }

        int numberOfDigitsRemoved = bestFirstDigitIndex;
        if (numberOfDigitsRemoved == k) {
            return s.substring(k);
        } else {
            int numberOfMoreDigitsToRemove = k - numberOfDigitsRemoved;
            return s.charAt(bestFirstDigitIndex) + helper(s.substring(bestFirstDigitIndex + 1), numberOfMoreDigitsToRemove);
        }
    }

    /******************************************************************/
    /******************** OPTIMIZED USING STACK ***********************/
    /******************************************************************/
    public String removeKdigits_Optimized(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char cur = num.charAt(i);
            // If remove all the previous digits that are greater than cur
            // Keep track of how many digits are removed
            while (k > 0 && !stack.isEmpty() && stack.peek() > cur) {
                stack.pop();
                k--;
            }

            stack.push(cur);
        }

        // For strict increasing seq or all equal numbers
        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        String smallestNum = sb.reverse().toString();
        return removeLeadingZeroes(smallestNum);
    }
}
