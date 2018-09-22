/*
https://leetcode.com/problems/reverse-string-ii/

Given a string and an integer k, you need to reverse the first k characters for every 2k characters 
counting from the start of the string. If there are less than k characters left, reverse all of them. 
If there are less than 2k but greater than or equal to k characters, then reverse the first k characters 
and left the other as original.

Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
*/

class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int start = 0;

        while (start < arr.length) {
            reverse(arr, start, k);
            start = start + 2 * k;
        }

        return new String(arr);
    }

    private void reverse(char[] arr, int start, int k) {
        int end = Math.min(start + k, arr.length) - 1;
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
