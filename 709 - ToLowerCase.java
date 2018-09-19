/*
https://leetcode.com/problems/to-lower-case/

Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
Example:
Input: "LOVELY"
Output: "lovely"
*/

public class ToLowerCase {
    public String toLowerCase(String str) {
        char[] out = str.toCharArray();
        for (int i = 0; i < out.length; i++) {
            if (isUpper(out[i])) {
                out[i] = toLower(out[i]);
            }
        }

        return String.valueOf(out);
    }

    private boolean isUpper(char c) {
        return c >= 65 && c <= 90;
    }

    private char toLower(char c) {
        return (char) ('a' + (c - 'A'));
    }
}
