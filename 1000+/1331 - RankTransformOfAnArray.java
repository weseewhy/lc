/*
https://leetcode.com/problems/rank-transform-of-an-array/

Given an array of integers arr, replace each element with its rank.
The rank represents how large the element is. The rank has the following rules:
  . Rank is an integer starting from 1.
  . The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
  . Rank should be as small as possible.

Example 1:
Input: arr = [40,10,20,30]
Output: [4,1,2,3]

Example 2:
Input: arr = [100,100,100]
Output: [1,1,1]

Example 3:
Input: arr = [37,12,28,9,100,56,80,5,12]
Output: [5,3,4,2,8,6,7,1,3]
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Set<Integer> set = new TreeSet<>();
        for (int val : arr) {
            set.add(val);
        }

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for (int val : set) {
            map.put(val, ++rank);
        }

        int[] out = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            out[i] = map.get(arr[i]);
        }

        return out;
    }
}
