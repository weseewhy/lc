/*
https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/

Given an integer n, return a string with n characters such that each character in such string occurs 
an odd number of times. The returned string must contain only lowercase English letters. 
If there are multiples valid strings, return any of them.  

Example 1:
Input: n = 4
Output: "pppz"

Example 2:
Input: n = 2
Output: "xy"

Example 3:
Input: n = 7
Output: "holasss"
*/

import java.util.Arrays;

class Solution {
    public String generateTheString(int n) {
        char[] chars = new char[n];
        Arrays.fill(chars, 'a');
        if (n % 2 == 0) {
            chars[n - 1] = 'b';
        }

        return new String(chars);
    }
}
