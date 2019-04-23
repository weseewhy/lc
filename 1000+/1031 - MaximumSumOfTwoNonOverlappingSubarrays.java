/*
https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/

Given an array A of non-negative integers, return the maximum sum of elements in two non-overlapping (contiguous) subarrays,
which have lengths L and M.  (For clarification, the L-length subarray could occur before or after the M-length subarray.)

Formally, return the largest V for which V = (A[i] + A[i+1] + ... + A[i+L-1]) + (A[j] + A[j+1] + ... + A[j+M-1]) and either:
0 <= i < i + L - 1 < j < j + M - 1 < A.length, or
0 <= j < j + M - 1 < i < i + L - 1 < A.length.

Example 1:
Input: A = [0,6,5,2,2,5,1,9,4], L = 1, M = 2
Output: 20
Explanation: One choice of subarrays is [9] with length 1, and [6,5] with length 2.

Example 2:
Input: A = [3,8,1,3,2,1,8,9,0], L = 3, M = 2
Output: 29
Explanation: One choice of subarrays is [3,8,1] with length 3, and [8,9] with length 2.

Example 3:
Input: A = [2,1,5,6,0,9,5,0,3,8], L = 4, M = 3
Output: 31
Explanation: One choice of subarrays is [5,6,0,9] with length 4, and [3,8] with length 3.
*/

class Solution {

    // 2 Pass with O(n) extra space
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int[] prefixSum = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + A[i];
        }

        return Math.max(findMax(prefixSum, L, M), findMax(prefixSum, M, L));
    }

    // fsal = first sub-array length, ssal - second sub-array length
    // fsa comes before ssa
    // for each second subarray, find sub array with max sum
    private int findMax(int[] prefixSum, int fsal, int ssal) {
        int maxTotalSum = 0;
        int bestFirstArraySum = 0;

        for (int i = fsal + ssal; i < prefixSum.length; i++) {
            int currentFirstSubArraySum = prefixSum[i - ssal] - prefixSum[i - fsal - ssal];
            bestFirstArraySum = Math.max(bestFirstArraySum, currentFirstSubArraySum);

            int secondSubArraySum = prefixSum[i] - prefixSum[i - ssal];
            maxTotalSum = Math.max(maxTotalSum, bestFirstArraySum + secondSubArraySum);
        }

        return maxTotalSum;
    }

    // Single Pass and no Extra space
    // Same idea as above. Keep track of possibilities for both sub-arrays at same time
    // https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/discuss/278251
    public int maxSumTwoNoOverlap_V2(int[] A, int L, int M) {
        for (int i = 1; i < A.length; ++i)
            A[i] += A[i - 1];
        int res = A[L + M - 1], Lmax = A[L - 1], Mmax = A[M - 1];
        for (int i = L + M; i < A.length; ++i) {
            Lmax = Math.max(Lmax, A[i - M] - A[i - L - M]);
            Mmax = Math.max(Mmax, A[i - L] - A[i - L - M]);
            res = Math.max(res, Math.max(Lmax + A[i] - A[i - M], Mmax + A[i] - A[i - L]));
        }
        return res;
    }
}
