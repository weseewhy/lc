/*
https://leetcode.com/problems/reverse-words-in-a-string-iii/

Given a string, you need to reverse the order of characters in each word within a sentence 
while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
*/

class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int start = 0;
        while (start < arr.length && arr[start] == ' ') {
            start++;
        }

        while (start < arr.length) {
            int end = start;
            while (end < arr.length && arr[end] != ' ') {
                end++;
            }
            end--;
            reverse(arr, start, end);

            start = end + 1;
            while (start < arr.length && arr[start] == ' ') {
                start++;
            }
        }

        return new String(arr);
    }

    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
