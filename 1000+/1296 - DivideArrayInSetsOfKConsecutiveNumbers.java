/*
https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/

Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into sets of k consecutive numbers
Return True if its possible otherwise return False.

Example 1:
Input: nums = [1,2,3,3,4,4,5,6], k = 4
Output: true
Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].

Example 2:
Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
Output: true
Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].

Example 3:
Input: nums = [3,3,2,2,1,1], k = 3
Output: true

Example 4:
Input: nums = [1,2,3,4], k = 3
Output: false
Explanation: Each array should be divided in subarrays of size 3.

Constraints:
    1 <= nums.length <= 10^5
    1 <= nums[i] <= 10^9
    1 <= k <= nums.length
*/

import java.util.Map;
import java.util.TreeMap;

class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }

        Map<Integer, Integer> map = new TreeMap<>();
        for (int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        while (!map.isEmpty()) {
            int num = map.keySet().iterator().next();
            int cnt = map.get(num);
            for (int i = 0; i < k; i++, num++) {
                if (map.getOrDefault(num, 0) < cnt) {
                    return false;
                }
                map.put(num, map.get(num) - cnt);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }

        return true;
    }
}
