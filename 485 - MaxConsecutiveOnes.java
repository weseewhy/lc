/*
https://leetcode.com/problems/max-consecutive-ones/

Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        boolean seq = false;
        int max = 0;
        int curLen = 0;
        for (int num : nums) {
            if (num == 1) {
                if (seq) {
                    curLen++;
                } else {
                    seq = true;
                    curLen = 1;
                }
            } else {
                seq = false;
                if (curLen > max) {
                    max = curLen;
                }
                curLen = 0;
            }
        }

        return max > curLen ? max : curLen;
    }
}
