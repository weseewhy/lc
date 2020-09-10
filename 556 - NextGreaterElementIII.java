/*
https://leetcode.com/problems/next-greater-element-iii/

Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which 
has exactly the same digits existing in the integer n and is greater in value than n. 
If no such positive 32-bit integer exists, you need to return -1.

Example 1:
Input: 12
Output: 21

Example 2:
Input: 21
Output: -1
*/

class Solution {
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        if (s.length() <= 1) {
            return -1;
        }

        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) - '0';
        }

        // First index from right that's smaller than previous
        int wrongIndex = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                wrongIndex = i;
                break;
            }
        }

        // Descending order
        if (wrongIndex < 0) {
            return -1;
        }

        // ... [wrongIndexVal][Greater numbers][Smaller numbers]
        // eg: ...[5][9,8,7][3,2,1]
        // Swap the first index that's greater than the val at wrongIndex
        for (int i = arr.length - 1; i > wrongIndex; i--) {
            if (arr[i] > arr[wrongIndex]) {
                swap(arr, wrongIndex, i);
                break;
            }
        }

        // Then remaining numbers after wrongIndex should be ascending
        // Since the numbers are already descending, just reverse them
        int left = wrongIndex + 1;
        int right = arr.length - 1;
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }

        long val = toNum(arr);
        if (val > Integer.MAX_VALUE) {
            return -1;
        }

        return (int) val;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private long toNum(int[] arr) {
        long l = arr[0];
        for (int i = 1; i < arr.length; i++) {
            l = l * 10 + arr[i];
        }
        return l;
    }
}
