/*
https://leetcode.com/problems/longest-arithmetic-sequence/

Given an array A of integers, return the length of the longest arithmetic subsequence in A.

Example 1:
Input: [3,6,9,12]
Output: 4
Explanation: The whole array is an arithmetic sequence with steps of length = 3.

Example 2:
Input: [9,4,7,2,10]
Output: 3
Explanation: The longest arithmetic subsequence is [4,7,10].

Example 3:
Input: [20,1,15,3,10,5,8]
Output: 4
Explanation: The longest arithmetic subsequence is [20,15,10,5].
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestArithSeqLength(int[] A) {
        if (A.length <= 2) {
            return A.length;
        }

        // Keep track of differences, the index of last element for each diff and
        // the length of the seq with that diff and ending at that index
        Map<Integer, Map<Integer, Integer>> diffMap = new HashMap<>();
        int maxLen = 0;

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                diffMap.putIfAbsent(diff, new HashMap<>());

                Map<Integer, Integer> seq = diffMap.get(diff);
                seq.put(i, seq.getOrDefault(j, 1) + 1);
                maxLen = Math.max(maxLen, seq.get(i));
            }
        }

        return maxLen;
    }
}
