/*
https://leetcode.com/problems/relative-sort-array/

Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. 
Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.

Example 1:
Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]

Constraints:
    . arr1.length, arr2.length <= 1000
    . 0 <= arr1[i], arr2[i] <= 1000
    . Each arr2[i] is distinct.
    . Each arr2[i] is in arr1.
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int[] relativeSortArray_1(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        for (int val : arr1) {
            cnt[val]++;
        }

        int[] out = new int[arr1.length];
        int writeIndex = 0;
        for (int val : arr2) {
            while (cnt[val]-- > 0) {
                out[writeIndex++] = val;
            }
        }
        for (int i = 0; i < cnt.length; i++) {
            while (cnt[i]-- > 0) {
                out[writeIndex++] = i;
            }
        }

        return out;
    }

    public int[] relativeSortArray_2(int[] arr1, int[] arr2) {
        Map<Integer, Integer> set = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            set.put(arr2[i], i);
        }

        return Arrays.stream(arr1)
                .boxed()
                .sorted((a, b) -> {
                    if (set.containsKey(a) && set.containsKey(b)) {
                        return set.get(a) - set.get(b);
                    } else if (set.containsKey(a)) {
                        return a;
                    } else if (set.containsKey(b)) {
                        return b;
                    } else {
                        return a - b;
                    }
                })
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
