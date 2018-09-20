/*
https://leetcode.com/problems/degree-of-an-array/

Given a non-empty array of non-negative integers nums, the degree of this
array is defined as the maximum frequency of any one of its elements.
Your task is to find the smallest possible length of a (contiguous) subarray of nums,
that has the same degree as nums.

Example 1:
Input: [1, 2, 2, 3, 1]
Output: 2
Explanation:
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:
Input: [1,2,2,3,1,4,2]
Output: 6

*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findShortestSubArray(int[] nums) {
        int degree = 0;
        Map<Integer, Count> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Count cnt = map.get(nums[i]);
            if (cnt == null) {
                cnt = new Count(i);
                map.put(nums[i], cnt);
            } else {
                cnt.increment(i);
            }

            degree = Math.max(degree, cnt.getFreq());
        }

        int minSubArrayLength = nums.length;
        for (int num : map.keySet()) {
            Count cnt = map.get(num);
            if (cnt.getFreq() == degree && cnt.getSubArrayLength() < minSubArrayLength) {
                minSubArrayLength = cnt.getSubArrayLength();
            }
        }

        return minSubArrayLength;
    }

    private class Count {
        private int freq;
        private int startIndex;
        private int endIndex;

        Count(int index) {
            this.freq = 1;
            this.startIndex = index;
            this.endIndex = index;
        }

        void increment(int index) {
            this.freq += 1;
            this.endIndex = index;
        }

        private int getFreq() {
            return this.freq;
        }

        public int getStartIndex() {
            return startIndex;
        }

        public int getEndIndex() {
            return endIndex;
        }

        public int getSubArrayLength() {
            return endIndex - startIndex + 1;
        }
    }
}
