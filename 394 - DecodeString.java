/*
https://leetcode.com/problems/decode-string/

Given an encoded string, return it's decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets
is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits
are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:
s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
s = "2[b4[F]c]
*/

import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Character> chars = new Stack<>();
        Stack<Integer> times = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int val = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    val = val * 10 + (s.charAt(++i) - '0');
                }
                times.push(val);
            } else if (Character.isLetter(c) || c == '[') {
                chars.push(c);
            } else if (c == ']') {
                int val = times.pop();
                StringBuilder sb = new StringBuilder();
                while (chars.peek() != '[') {
                    sb.append(chars.pop());
                }
                chars.pop();

                String rep = sb.reverse().toString();
                for (int j = 0; j < val; j++) {
                    for (char ch : rep.toCharArray()) {
                        chars.push(ch);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }
}
