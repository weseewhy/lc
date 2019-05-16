/*
https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/

We are given an array A of positive integers, and two positive integers L and R (L <= R).
Return the number of (contiguous, non-empty) subarrays such that the value of the maximum 
array element in that subarray is at least L and at most R.

Example :
Input: A = [2, 1, 4, 3], L = 2, R = 3
Output: 3
Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
*/

class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int lastInvalidIndex = -1;
        int dpiMinus1 = 0;
        int total = 0;

        for (int i = 0; i < A.length; i++) {
            int dpi;
            if (A[i] < L) {
                dpi = dpiMinus1;
            } else if (A[i] > R) {
                dpi = 0;
                lastInvalidIndex = i;
            } else {
                dpi = i - lastInvalidIndex;
            }

            total += dpi;
            dpiMinus1 = dpi;
        }

        return total;
    }
}

/*
dp[i] --> Number of valid sub-arrays satisfying given condition and ending at index 'i'
prev  --> Index of last invalid sub-array ending

dp[i] = dp[i-1]  when A[i] < L (This element can join the sub-arrays ending at 'i-1' with same MAX for arrays ending at 'i-1')
      = 0        when A[i] > R (The max of sub-array ending at this index will definitely > R. so invalid. Also set, prev = i)
      = i-prev   when L <= A[i] <= R (All the sub-arrays starting after 'prev' will be valid)
*/
