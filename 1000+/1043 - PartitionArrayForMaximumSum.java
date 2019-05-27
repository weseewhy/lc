/*
https://leetcode.com/problems/partition-array-for-maximum-sum/

Given an integer array A, you partition the array into (contiguous) subarrays of length at most K. 
After partitioning, each subarray has their values changed to become the maximum value of that subarray.
Return the largest sum of the given array after partitioning.

Example 1:
Input: A = [1,15,7,9,2,5,10], K = 3
Output: 84
Explanation: A becomes [15,15,15,9,10,10,10]
*/

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        int max = arr[0];
        for (int i = 0; i < Math.min(k, arr.length); i++) {
            max = Math.max(max, arr[i]);
            dp[i] = (i + 1) * max;
        }

        for (int i = k; i < arr.length; i++) {
            int subArrayMax = arr[i];
            for (int j = 1; j <= k; j++) {
                subArrayMax = Math.max(subArrayMax, arr[i - j + 1]);
                dp[i] = Math.max(dp[i], dp[i - j] + subArrayMax * j);
            }
        }

        return dp[dp.length - 1];
    }
}

/*
dp[i]  -> max sum after partitioning until index i

dp[i] = dp[i-1] + arr[i]                             --> last element in it's own subarray
      = dp[i-2] + Max[arr[i], arr[i-1]] * 2          --> last 2 elements in one subarray
        ...
        ...
      = dp[i-k] + Max[arr[i], ..., arr[i-k+1]] * k   --> last k elements in one subarray 
*/
