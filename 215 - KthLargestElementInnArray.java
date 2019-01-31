/*
https://leetcode.com/problems/kth-largest-element-in-an-array/description/

Find the kth largest element in an unsorted array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:
Input: [3,2,1,5,6,4] and k = 2
Output: 5

Example 2:
Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
*/

import java.util.PriorityQueue;

class Solution {

    // O(Nlog(k)) time, O(k) space
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[k]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        return minHeap.peek();
    }

    // O(N) average and O(N^2) worst case time complexity, O(1) space complexity
    public int findKthLargest_Optimized(int[] nums, int k) {
        return findKthSmallest(nums, nums.length - k + 1);
    }

    private int findKthSmallest(int[] arr, int k) {
        int indexOfKthSmallest = findKthSmallest(arr, 0, arr.length - 1, k);
        return arr[indexOfKthSmallest];
    }

    private int findKthSmallest(int[] arr, int start, int end, int k) {
        int pivotIndex = select(arr, start, end);
        if (pivotIndex == k - 1) {
            return pivotIndex;
        } else if (pivotIndex < k - 1) {
            return findKthSmallest(arr, pivotIndex + 1, end, k);
        } else {
            return findKthSmallest(arr, start, pivotIndex - 1, k);
        }
    }

    private int select(int[] arr, int start, int end) {
        int lastSmallerAt = start - 1;
        for (int cur = start; cur < end; cur++) {
            if (arr[cur] <= arr[end]) {
                lastSmallerAt++;
                swap(arr, cur, lastSmallerAt);
            }
        }

        lastSmallerAt++;
        swap(arr, end, lastSmallerAt);
        return lastSmallerAt;
    }

    private void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
