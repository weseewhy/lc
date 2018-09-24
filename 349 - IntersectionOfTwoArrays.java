/*
https://leetcode.com/problems/intersection-of-two-arrays/

Given two arrays, write a function to compute their intersection.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]

Note:
Each element in the result must be unique.
The result can be in any order.
*/

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        for (int i : nums1) {
            nums1Set.add(i);
        }

        Set<Integer> out = new HashSet<>();
        for (int i : nums2) {
            if (nums1Set.contains(i)) {
                out.add(i);
            }
        }

        return out.stream().mapToInt(Integer::intValue).toArray();
    }
}
