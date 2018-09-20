/*
https://leetcode.com/problems/reverse-string/

Write a function that takes a string as input and returns the string reversed.

Example 1:
Input: "hello"
Output: "olleh"

Example 2:
Input: "A man, a plan, a canal: Panama"
Output: "amanaP :lanac a ,nalp a ,nam A"
*/

class Solution {
    public String reverseString(String s) {
        char[] buf = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char temp = buf[start];
            buf[start] = buf[end];
            buf[end] = temp;
            start++;
            end--;
        }

        return new String(buf);
    }
}
