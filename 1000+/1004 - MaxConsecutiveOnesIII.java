/*
https://leetcode.com/problems/max-consecutive-ones-iii/

Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
Return the length of the longest (contiguous) subarray that contains only 1s.

Example 1:
Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
Output: 6
Explanation: 0s at index 5,10 are flipped

Example 2:
Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
Output: 10
Explanation: 0s at index 4,5,9 are flipped
*/

class Solution {
    // Invariant: Window will always have 1s and Number of 0s flipped <= k
    // Extend the window at every step. If the invariant breaks, then reduce the window size
    // (by moving the start of the window to right) until the invariant is satisfied (recover the last flipped 0)
    public int longestOnes(int[] arr, int k) {
        int start = 0;
        int numberOfZeroesFlipped = 0;
        int res = 0;

        for (int end = 0; end < arr.length; end++) {
            if (arr[end] == 0) {
                numberOfZeroesFlipped++;

                if (numberOfZeroesFlipped > k) {
                    // Reduce window size
                    // Skip all the 1s at start. They didn't cause any flips
                    while (arr[start] == 1) {
                        start++;
                    }

                    // We are at the last flipped 0. Recover it
                    numberOfZeroesFlipped--;
                    start++;
                }
            }

            // Check if current window size is > max we have seen so far
            res = Math.max(res, end - start + 1);
        }

        return res;
    }
}
