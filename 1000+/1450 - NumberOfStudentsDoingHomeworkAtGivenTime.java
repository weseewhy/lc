/*
https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/

Given two integer arrays startTime and endTime and given an integer queryTime.
The ith student started doing their homework at the time startTime[i] and finished it at time endTime[i].
Return the number of students doing their homework at time queryTime.

Example 1:
Input: startTime = [1,2,3], endTime = [3,2,7], queryTime = 4
Output: 1

Example 2:
Input: startTime = [9,8,7,6,5,4,3,2,1], endTime = [10,10,10,10,10,10,10,10,10], queryTime = 5
Output: 5
*/

class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int cnt = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                cnt++;
            }
        }
        return cnt;
    }
}
