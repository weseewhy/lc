/*
https://leetcode.com/problems/largest-time-for-given-digits/

Given an array of 4 digits, return the largest 24 hour time that can be made.
The smallest 24 hour time is 00:00, and the largest is 23:59.  
Starting from 00:00, a time is larger if more time has elapsed since midnight.
Return the answer as a string of length 5.  If no valid time can be made, return an empty string.

Example 1:
Input: [1,2,3,4]
Output: "23:41"

Example 2:
Input: [5,5,5,5]
Output: ""

Note:
A.length == 4
0 <= A[i] <= 9
*/

class Solution {
    public String largestTimeFromDigits(int[] A) {
        int max = -1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) continue;
                int hours = A[i] * 10 + A[j];
                if (hours >= 24) continue;
                for (int k = 0; k < 4; k++) {
                    if (i == k || j == k) continue;
                    int l = 6 - i - j - k;
                    int minutes = A[k] * 10 + A[l];
                    if (minutes >= 60) continue;
                    max = Math.max(max, hours * 60 + minutes);
                }
            }
        }

        return max == -1 ? "" : String.format("%02d:%02d", max / 60, max % 60);
    }
}
