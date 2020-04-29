/*
https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/

Given an array arr, replace every element in that array with the greatest element 
among the elements to its right, and replace the last element with -1.
After doing so, return the array.

Example 1:
Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]
*/

class Solution {
    public int[] replaceElements(int[] arr) {
        int lastIndex = arr.length - 1;
        int max = arr[lastIndex];
        arr[lastIndex] = -1;

        for (int i = lastIndex - 1; i >= 0; i--) {
            int val = arr[i];
            arr[i] = max;
            max = Math.max(max, val);
        }

        return arr;
    }
}
