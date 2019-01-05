/*
https://leetcode.com/problems/student-attendance-record-i/

You are given a string representing an attendance record for a student. 
The record only contains the following three characters:
'A' : Absent.
'L' : Late.
'P' : Present.

A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
You need to return whether the student could be rewarded according to his attendance record.

Example 1:
Input: "PPALLP"
Output: True

Example 2:
Input: "PPALLL"
Output: False
*/

class Solution {
    public boolean checkRecord(String s) {
        boolean absent = false;
        int consecutiveLs = 0;

        for (char c : s.toCharArray()) {
            if (c == 'L') {
                if (consecutiveLs == 2) {
                    return false;
                }

                consecutiveLs++;
            } else {
                if (c == 'A') {
                    if (absent) {
                        return false;
                    }
                    absent = true;
                }

                consecutiveLs = 0;
            }
        }

        return true;
    }
}
