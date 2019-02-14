/*
Given an array of integers and an integer k, find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input: nums = [1,1,1], k = 2
Output: 2

Example 2:
Input: nums = [10,2,-2,-20,10], k = -10
Output: 3  
Explanation: [10,2,-2,-20], [2,-2,-20,10], [-20,10]
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int target) {
        int cnt = 0;
        int sum = 0;

        // Number of times a prefix sum is encountered
        Map<Integer, Integer> prefixMap = new HashMap<>();

        // Searching for prefix sum 0 implies current sum == target
        prefixMap.put(0, 1);

        for (int num : nums) {
            sum += num;

            int desiredPrefixSumToReachTarget = sum - target;
            if (prefixMap.containsKey(desiredPrefixSumToReachTarget)) {
                cnt += prefixMap.get(desiredPrefixSumToReachTarget);
            }
            
            // Increment the occurrences of current sum
            prefixMap.put(sum, prefixMap.getOrDefault(sum, 0) + 1);
        }

        return cnt;
    }
}

/*
Hint:
subarray_sum(i, j) = prefixSum(j) - prefixSum(i)  
At any index, find if the sum of elements in subarray from any of the previous index == target (we use map for fast lookup)
*/
