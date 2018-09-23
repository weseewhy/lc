/*
https://leetcode.com/problems/number-of-segments-in-a-string/

Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
Please note that the string does not contain any non-printable characters.

Example:
Input: "Hello, my name is John"
Output: 5
*/

class Solution {
    public int countSegments(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int cnt = s.charAt(0) == ' ' ? 0 : 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == ' ' && s.charAt(i + 1) != ' ') {
                cnt++;
            }
        }

        return cnt;
    }
}
