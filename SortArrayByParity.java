/*
https://leetcode.com/problems/sort-array-by-parity/

Given an array A of non-negative integers, return an array consisting of all the even elements of A, 
followed by all the odd elements of A. You may return any answer array that satisfies this condition.

Example 1:
Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
*/

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            while (start < end && arr[start] % 2 == 0) {
                start++;
            }

            while (start < end && arr[end] % 2 == 1) {
                end--;
            }

            swap(arr, start, end);
        }

        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
