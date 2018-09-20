/*
https://leetcode.com/problems/length-of-last-word/

Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
return the length of last word in the string.
If the last word does not exist, return 0.
Note: A word is defined as a character sequence consists of non-space characters only.

Example:
Input: "Hello World"
Output: 5
*/

class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }

        for (int i = end; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }

            len++;
        }

        return len;
    }
}
