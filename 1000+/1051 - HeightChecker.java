/*
https://leetcode.com/problems/height-checker/

Students are asked to stand in non-decreasing order of heights for an annual photo.
Return the minimum number of students not standing in the right positions.  
(This is the number of students that must move in order for all students to be standing in non-decreasing order of height.)

Example 1:
Input: [1,1,4,2,1,3]
Output: 3
Explanation: Students with heights 4, 3 and the last 1 are not standing in the right positions.
*/

import java.util.Arrays;

class Solution {
    public int heightChecker(int[] heights) {
        int[] buff = Arrays.copyOf(heights, heights.length);
        Arrays.sort(buff);
        int cnt = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != buff[i]) {
                cnt++;
            }
        }

        return cnt;
    }
}
