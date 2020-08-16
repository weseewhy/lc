/*
https://leetcode.com/problems/three-consecutive-odds/

Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.

Example 1:
Input: arr = [2,6,4,1]
Output: false
Explanation: There are no three consecutive odds.

Example 2:
Input: arr = [1,2,34,3,4,5,7,23,12]
Output: true
Explanation: [5,7,23] are three consecutive odds.
*/

class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int cnt = 0;
        for (int i = 0; i < arr.length && cnt < 3; i++) {
            cnt = arr[i] % 2 == 0 ? 0 : cnt + 1;
        }
        return cnt == 3;
    }
}
