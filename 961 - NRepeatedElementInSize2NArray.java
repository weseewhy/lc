/*
https://leetcode.com/problems/n-repeated-element-in-size-2n-array

In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
Return the element repeated N times.

Example 1:
Input: [1,2,3,3]
Output: 3

Example 2:
Input: [2,1,2,5,3,2]
Output: 2

Example 3:
Input: [5,1,5,2,5,3,5,4]
Output: 5
*/

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int repeatedNTimes(int[] A) {
        int start = 0;
        int end;
        Set<Integer> set = new HashSet<>(4);

        // One subset of length 4 will contain majority element
        while (start < A.length) {
            end = Math.min(start + 3, A.length - 1);
            set.clear();

            for (int i = start; i <= end; i++) {
                if (set.contains(A[i])) {
                    return A[i];
                }
                set.add(A[i]);
            }

            start = start + 3;
        }

        return -1;
    }

}
