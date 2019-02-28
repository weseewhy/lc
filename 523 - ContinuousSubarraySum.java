/*
https://leetcode.com/problems/continuous-subarray-sum/

Given a list of non-negative numbers and a target integer k,
write a function to check if the array has a continuous subarray of size at least 2
that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.

Example 1:
Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.

Example 2:
Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length <= 1) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if (k != 0) {
                runningSum = runningSum % k;
            }

            // If we found this same value at index j, then sub-array (j, i] contains target sum
            Integer prevIndex = map.get(runningSum);
            if (prevIndex == null) {
                map.put(runningSum, i);
            } else if (i - prevIndex > 1) {
                return true;
            }
        }

        return false;
    }
}

/*
Hint: https://leetcode.com/problems/continuous-subarray-sum/discuss/99499
 */
