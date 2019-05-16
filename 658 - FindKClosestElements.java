/*
https://leetcode.com/problems/find-k-closest-elements/

Given a sorted array, two integers k and x, find the k closest elements to x in the array.
The result should also be sorted in ascending order.
If there is a tie, the smaller elements are always preferred.

Example 1:
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]

Example 2:
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]
*/

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (x <= arr[0]) {
            return Arrays.stream(arr).boxed().limit(k).collect(Collectors.toList());
        } else if (x >= arr[arr.length - 1]) {
            return Arrays.stream(arr).boxed().skip(arr.length - k).collect(Collectors.toList());
        } else {
            int index = Arrays.binarySearch(arr, x);
            if (index < 0) {
                index = -index - 1;
            }

            // Desired elements will be between these two indices (not included)
            // Start with empty list and expand on both sides
            int left = index - 1;
            int right = index;

            for (int i = 1; i <= k; i++) {
                if (left < 0 || (right < arr.length && arr[right] - x < x - arr[left])) {
                    right++;
                } else {
                    left--;
                }
            }

            return Arrays.stream(arr).boxed().skip(left + 1).limit(k).collect(Collectors.toList());
        }
    }
}
