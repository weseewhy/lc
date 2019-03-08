/*
https://leetcode.com/problems/longest-harmonious-subsequence/

We define a harmonious array is an array where the difference between 
its maximum value and its minimum value is exactly 1.

Now, given an integer array, you need to find the length of its 
longest harmonious subsequence among all its possible subsequences.

Example 1:
Input: [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i : nums) {
            cnt.put(i, cnt.getOrDefault(i, 0) + 1);
        }

        int maxLength = 0;
        for (int val : cnt.keySet()) {
            if (cnt.containsKey(val + 1)) {
                maxLength = Math.max(maxLength, cnt.get(val) + cnt.get(val + 1));
            }
        }

        return maxLength;
    }
}
