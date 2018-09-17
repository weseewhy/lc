/*
https://leetcode.com/problems/backspace-string-compare/

Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:
Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".

Example 2:
Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".

Example 3:
Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".

Example 4:
Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
*/

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        return transform(s).equals(transform(t));
    }

    private static String transform(String s) {
        StringBuilder sb = new StringBuilder();
        int backSpaceCount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                backSpaceCount++;
            } else if (backSpaceCount > 0) {
                backSpaceCount--;
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.reverse().toString();
    }
}
