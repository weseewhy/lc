/*
https://leetcode.com/problems/longest-turbulent-subarray/

A subarray A[i], A[i+1], ..., A[j] of A is said to be turbulent if and only if:
For i <= k < j, A[k] > A[k+1] when k is odd, and A[k] < A[k+1] when k is even;
OR, for i <= k < j, A[k] > A[k+1] when k is even, and A[k] < A[k+1] when k is odd.
That is, the subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.

Return the length of a maximum size turbulent subarray of A.

Example 1:
Input: [9,4,2,10,7,8,8,1,9]
Output: 5
Explanation: (A[1] > A[2] < A[3] > A[4] < A[5])

Example 2:
Input: [4,8,12,16]
Output: 2

Example 3:
Input: [100]
Output: 1
*/

class Solution {
    public int maxTurbulenceSize(int[] A) {
        if (A.length <= 1) {
            return A.length;
        }

        int[] arr = new int[A.length - 1];
        for (int i = 1; i < A.length; i++) {
            arr[i - 1] = Integer.compare(A[i], A[i - 1]);
        }

        return flips(arr) + 1;
    }

    private int flips(int[] arr) {
        int max = 0;
        int left = -1;
        for (int i = 0; i < arr.length; i++) {
            if (left == -1) {
                if (arr[i] != 0) {
                    left = i;
                    // If we find atleast one such left, we have atleast 1 flip
                    max = Math.max(max, 1);
                }
            } else {
                if (arr[i] + arr[i - 1] == 0) {
                    max = Math.max(max, i - left + 1);
                } else {
                    left = arr[i] != 0 ? i : -1;
                }
            }
        }

        return max;
    }
}
