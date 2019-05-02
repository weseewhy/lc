/*
https://leetcode.com/problems/subarray-sums-divisible-by-k/

Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.

Example 1:
Input: A = [4,5,0,-2,-3,1], K = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by K = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraysDivByK(int[] arr, int k) {
        // Holds the (PrefixSum % k)
        // If two indices have same prefix sum mod, then the sub-array sum b/w those indices is divisible by k
        int[] prefixSumModK = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            prefixSumModK[i + 1] = (prefixSumModK[i] + arr[i]) % k;
            // We want the positive mod
            while (prefixSumModK[i + 1] < 0) {
                prefixSumModK[i + 1] += k;
            }
        }

        // Holds the number of same MOD indices we have seen so far
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int mod : prefixSumModK) {
            int sameMods = map.getOrDefault(mod, 0);
            cnt += sameMods;
            map.put(mod, sameMods + 1);
        }

        return cnt;
    }
}
