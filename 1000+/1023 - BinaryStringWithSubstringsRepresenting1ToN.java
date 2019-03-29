/*
https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n/

Given a binary string S (a string consisting only of '0' and '1's) and a positive integer N, 
return true if and only if for every integer X from 1 to N, the binary representation of X is a substring of S.

Example 1:
Input: S = "0110", N = 3
Output: true

Example 2:
Input: S = "0110", N = 4
Output: false
*/

class Solution {
    public boolean queryString(String S, int N) {
        // If binary(n) is in S, then binary(n>>1) == binary(n/2) is also in S 
        for (int i = N; i >= N / 2; i--) {
            if (!S.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }

        return true;
    }
}