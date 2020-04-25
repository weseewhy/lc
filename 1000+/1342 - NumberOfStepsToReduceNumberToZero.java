/*
https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/

Given a non-negative integer num, return the number of steps to reduce it to zero.
If the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.

Example 1:
Input: num = 14
Output: 6
Explanation:
Step 1) 14 is even; divide by 2 and obtain 7.
Step 2) 7 is odd; subtract 1 and obtain 6.
Step 3) 6 is even; divide by 2 and obtain 3.
Step 4) 3 is odd; subtract 1 and obtain 2.
Step 5) 2 is even; divide by 2 and obtain 1.
Step 6) 1 is odd; subtract 1 and obtain 0.

Example 2:
Input: num = 8
Output: 4

Example 3:
Input: num = 123
Output: 12
*/
class Solution {
    public int numberOfSteps(int num) {
        int cnt = 0;
        while (num > 0) {
            if (num % 2 == 1) {
                num--;
            } else {
                num = num / 2;
            }
            cnt++;
        }
        return cnt;
    }
}
