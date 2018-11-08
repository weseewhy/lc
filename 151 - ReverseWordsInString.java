/*
https://leetcode.com/problems/reverse-words-in-a-string/

Given an input string, reverse the string word by word.

Example:  
Input: "the sky is blue",
Output: "blue is sky the".

Note:
A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
*/

public class Solution {
    public String reverseWords_preserveSpaces(String s) {
        char[] c = s.toCharArray();
        reverse(c, 0, s.length() - 1);

        int start = -1;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                if (start != -1) {
                    reverse(c, start, i - 1);
                    start = -1;
                }
            } else {
                if (start == -1) {
                    start = i;
                }
            }
        }

        if (start != -1) {
            reverse(c, start, c.length - 1);
        }

        return new String(c);
    }

    public String reverseWords_trimSpaces(String s) {
        int firstNonSpaceIndex = 0;
        int lastNonSpaceIndex = s.length() - 1;
        while (firstNonSpaceIndex < s.length() && s.charAt(firstNonSpaceIndex) == ' ') {
            firstNonSpaceIndex++;
        }

        while (lastNonSpaceIndex >= firstNonSpaceIndex && s.charAt(lastNonSpaceIndex) == ' ') {
            lastNonSpaceIndex--;
        }

        int len = 0;
        for (int i = firstNonSpaceIndex; i <= lastNonSpaceIndex; i++) {
            if (s.charAt(i) != ' ') {
                len++;
            } else if (i > 0 && s.charAt(i - 1) != ' ') {
                len++;
            }
        }

        char[] c = new char[len];
        int ci = 0;
        for (int i = firstNonSpaceIndex; i <= lastNonSpaceIndex; i++) {
            if ((s.charAt(i) != ' ') || (ci > 0 && c[ci - 1] != ' ')) {
                c[ci] = s.charAt(i);
                ci++;
            }
        }

        int start = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                reverse(c, start, i - 1);
                start = i + 1;
            }
        }

        if (start < s.length()) {
            reverse(c, start, c.length - 1);
        }

        reverse(c, 0, c.length - 1);
        return new String(c);
    }

    private void reverse(char[] c, int start, int end) {
        while (start < end) {
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;
            start++;
            end--;
        }
    }
}
