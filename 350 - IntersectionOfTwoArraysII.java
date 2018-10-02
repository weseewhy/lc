/*
https://leetcode.com/problems/intersection-of-two-arrays-ii/

Given two arrays, write a function to compute their intersection.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> cnt1 = new HashMap<>();
        for (int i : nums1) {
            cnt1.put(i, cnt1.getOrDefault(i, 0) + 1);
        }

        Map<Integer, Integer> cnt2 = new HashMap<>();
        for (int i : nums2) {
            cnt2.put(i, cnt2.getOrDefault(i, 0) + 1);
        }

        List<Integer> out = new ArrayList<>();
        for (int i : cnt1.keySet()) {
            if (cnt2.containsKey(i)) {
                int min = Math.min(cnt1.get(i), cnt2.get(i));
                while (min > 0) {
                    out.add(i);
                    min--;
                }
            }
        }

        return out.stream().mapToInt(Integer::intValue).toArray();
    }
}
