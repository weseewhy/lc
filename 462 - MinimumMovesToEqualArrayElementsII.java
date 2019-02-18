/*
https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/

Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, 
where a move is incrementing a selected element by 1 or decrementing a selected element by 1.

Example:
Input: [1,2,3]
Output: 2
Explanation:
Only two moves are needed (remember each move increments or decrements one element):
[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
*/

import java.util.Arrays;

class Solution {
    public int minMoves2(int[] nums) {
        if (nums == null || nums.length == 1) {
            return 0;
        }

        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int cnt = 0;

        // If all numbers become x, then first number requires x-nums[start] moves
        // and last number requires nums[end] - x moves
        // So total of nums[end] - nums[end] moves
        while (start < end) {
            cnt += nums[end] - nums[start];
            start++;
            end--;
        }

        return cnt;
    }
}
