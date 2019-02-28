/*
https://leetcode.com/problems/flip-string-to-monotone-increasing/submissions/

A string of '0's and '1's is monotone increasing if it consists of some number of '0's (possibly 0),
followed by some number of '1's (also possibly 0.)

We are given a string S of '0's and '1's, and we may flip any '0' to a '1' or a '1' to a '0'.
Return the minimum number of flips to make S monotone increasing.

Example 1:
Input: "00110"
Output: 1
Explanation: We flip the last digit to get 00111.

Example 2:
Input: "010110"
Output: 2
Explanation: We flip to get 011111, or alternatively 000111.

Example 3:
Input: "00011000"
Output: 2
Explanation: We flip to get 00000000.
*/

class Solution {
    public int minFlipsMonoIncr(String S) {
        if (S.length() <= 1) {
            return 0;
        }

        // Holds the min number of flips required to make it monotonic string
        // ending with 0 and 1 respectively
        int prev0 = S.charAt(0) == '0' ? 0 : 1;
        int prev1 = S.charAt(0) == '1' ? 0 : 1;

        int cur0, cur1;

        for (int i = 1; i < S.length(); i++) {
            boolean is0 = S.charAt(i) == '0';

            // Monotonic ending with 0 means all chars are 0
            // If the cur digit is 0, then no extra flips required to make it monotonic ending with 0
            // Otherwise 1 extra step to make it monotonic (all 0s except the last)
            cur0 = is0 ? prev0 : prev0 + 1;

            // Monotonic ending with 1 means ....01 or ....11
            // So take the min from those 2 options and flip current to 1 if needed
            cur1 = (is0 ? 1 : 0) + Math.min(prev0, prev1);

            prev0 = cur0;
            prev1 = cur1;
        }

        return Math.min(prev0, prev1);
    }
}
