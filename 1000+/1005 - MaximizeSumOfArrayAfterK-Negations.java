/*
https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/

Given an array A of integers, we must modify the array in the following way: 
we choose an i and replace A[i] with -A[i], and we repeat this process K times in total.  
(We may choose the same index i multiple times.)

Return the largest possible sum of the array after modifying it in this way.

Example 1:
Input: A = [4,2,3], K = 1
Output: 5
Explanation: Choose indices (1,) and A becomes [4,-2,3].

Example 2:
Input: A = [3,-1,0,2], K = 3
Output: 6
Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2].

Example 3:
Input: A = [2,-3,-1,5,-4], K = 2
Output: 13
Explanation: Choose indices (1, 4) and A becomes [2,3,-1,5,4].
*/

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int largestSumAfterKNegations(int[] arr, int k) {
        Arrays.sort(arr);
        int sum = 0;
        Integer min = null;

        for (int i = 0; i < arr.length; i++) {
            if (k > 0 && arr[i] < 0) {
                arr[i] = -arr[i];
                k--;
            }

            if (min == null || Math.abs(arr[i]) < min) {
                min = Math.abs(arr[i]);
            }

            sum += arr[i];
        }

        if (k % 2 == 1) {
            sum -= 2 * min;
        }

        return sum;
    }

    // Hint: Using priority queue
    // https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/discuss/252228
    public int largestSumAfterKNegations_V2(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : arr) {
            pq.offer(val);
        }

        while (k > 0) {
            pq.add(-pq.poll());
            k--;
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        return sum;
    }
}
