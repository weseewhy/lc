/*
https://leetcode.com/problems/convert-to-base-2/

Given a number N, return a string consisting of "0"s and "1"s that represents its value in base -2 (negative two).
The returned string must have no leading zeroes, unless the string is "0".

Example 1:
Input: 2
Output: "110"
Explanation: (-2) ^ 2 + (-2) ^ 1 = 2

Example 2:
Input: 3
Output: "111"
Explanation: (-2) ^ 2 + (-2) ^ 1 + (-2) ^ 0 = 3

Example 3:
Input: 4
Output: "100"
Explanation: (-2) ^ 2 = 4
*/

class Solution {
    public String baseNeg2(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(n & 1);
            n = -(n >> 1);
        }

        return sb.length() == 0 ? "0" : sb.reverse().toString();
    }
}
