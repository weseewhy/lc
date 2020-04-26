/*
https://leetcode.com/problems/maximum-69-number/submissions/

Given a positive integer num consisting only of digits 6 and 9.
Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).

Example 1:
Input: num = 9669
Output: 9969

Example 2:
Input: num = 9996
Output: 9999

Example 3:
Input: num = 9999
Output: 9999
*/

class Solution {
    public int maximum69Number(int num) {
        int firstSixIndex = -1;
        int val = num;
        int index = 0;
        while (val > 0) {
            if (val % 10 == 6) {
                firstSixIndex = index;
            }
            val = val / 10;
            index++;
        }

        if (firstSixIndex == -1) {
            return num;
        } else {
            // Add 3 at that index.
            // eg: for 9669, firstSixIndex = 2 (from end). Add 300 to make it 9969
            return num + 3 * (int) Math.pow(10, firstSixIndex);
        }
    }
}
