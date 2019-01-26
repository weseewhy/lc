/*
https://leetcode.com/problems/pancake-sorting/

Given an array A, we can perform a pancake flip:
We choose some positive integer k <= A.length, then reverse the order of the first k elements of A.

We want to perform zero or more pancake flips (doing them one after another in succession) to sort the array A.
Return the k-values corresponding to a sequence of pancake flips that sort A.
Any valid answer that sorts the array within 10 * A.length flips will be judged as correct.

Example 1:
Input: [3,2,4,1]
Output: [4,2,4,3]
Explanation:
We perform 4 pancake flips, with k values 4, 2, 4, and 3.
Starting state: A = [3, 2, 4, 1]
After 1st flip (k=4): A = [1, 4, 2, 3]
After 2nd flip (k=2): A = [4, 1, 2, 3]
After 3rd flip (k=4): A = [3, 2, 1, 4]
After 4th flip (k=3): A = [1, 2, 3, 4], which is sorted.

Example 2:
Input: [1,2,3]
Output: []
Explanation: The input is already sorted, so there is no need to flip anything.
Note that other answers, such as [3, 3], would also be accepted.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        return pancakeSort(arr, arr.length - 1);
    }

    // Idea is to find the index of max number. Flip that index to bring the number to index 0
    // Then flip the whole array to bring the number to the last index
    // Repeat the same process on array of size-1
    private List<Integer> pancakeSort(int[] arr, int end) {
        if (end == 0) {
            return Collections.emptyList();
        }

        int maxIndex = 0;
        for (int i = 1; i <= end; i++) {
            if (arr[i] >= arr[maxIndex]) {
                maxIndex = i;
            }
        }

        List<Integer> out = new ArrayList<>();
        if (maxIndex != end) {
            if (end != 1) {
                out.add(maxIndex);
                reverseArray(arr, maxIndex);
            }

            out.add(end);
            reverseArray(arr, end);
        }

        out.addAll(pancakeSort(arr, end - 1));
        return out;
    }

    private void reverseArray(int[] arr, int end) {
        int start = 0;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
