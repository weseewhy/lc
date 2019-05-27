/*
https://leetcode.com/problems/arithmetic-slices/

A slice (P, Q) of array A is called arithmetic if the sequence: A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic.
Find the number of arithmetic slices (of min length 3) in the array A.

Example:
Input: [1, 2, 3, 4]
Output: 3.
Explanation: 3 arithmetic slices: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
*/

class Solution {

    // Find the possible arithmetic windows
    public int numberOfArithmeticSlices(int[] arr) {
        int cnt = 0;
        for (int i = 2; i < arr.length; i++) {
            int diff = arr[i - 1] - arr[i - 2];
            int start = i;
            while (i < arr.length && arr[i] - arr[i - 1] == diff) {
                cnt += (i - start + 1);
                i++;
            }
        }

        return cnt;
    }

    // Using dynamic programming
    public int numberOfArithmeticSlices_dp(int[] arr) {
        int sum = 0;

        // dp[i] = number of arithmetic slices 'ENDING' at ith index
        int[] dp = new int[arr.length];

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == arr[i - 1] - arr[i - 2]) {
                // current index can join previous arithmetic slice
                dp[i] = dp[i - 1] + 1;
                sum += dp[i];
            }
        }

        return sum;
    }

    /*
    In above dp solution, we are using only last index. So no need for dp array.
    One variable to store dp[i-1] will be sufficient --> O(1) space
    */
}
