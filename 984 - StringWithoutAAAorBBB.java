/*
https://leetcode.com/problems/string-without-aaa-or-bbb/

Given two integers A and B, return any string S such that:
   - S has length A + B and contains exactly A 'a' letters, and exactly B 'b' letters;
   - The substring 'aaa' does not occur in S;
   - The substring 'bbb' does not occur in S.
 
Example 1:
Input: A = 1, B = 2
Output: "abb"
Explanation: "abb", "bab" and "bba" are all correct answers.

Example 2:
Input: A = 4, B = 1
Output: "aabaa"
*/

class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder(a + b);
        String repeat = a >= b ? "aab" : "bba";
        String normal = a >= b ? "ab" : "ba";
        String balance = a >= b ? "a" : "b";

        int max = Math.max(a, b);
        int min = Math.min(a, b);

        while (max - min > 1 && min > 0) {
            sb.append(repeat);
            max -= 2;
            min--;
        }

        while (min > 0) {
            sb.append(normal);
            max--;
            min--;
        }

        while (max > 0) {
            sb.append(balance);
            max--;
        }

        return sb.toString();
    }
}
