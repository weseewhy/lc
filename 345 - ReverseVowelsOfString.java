/*
https://leetcode.com/problems/reverse-vowels-of-a-string/

Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Input: "hello"
Output: "holle"

Example 2:
Input: "leetcode"
Output: "leotcede"
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    private Set<Character> VOWELS = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            while (start < end && !isVowel(arr[start])) {
                start++;
            }

            while (start < end && !isVowel(arr[end])) {
                end--;
            }

            if (isVowel(arr[start]) && isVowel(arr[end])) {
                swap(arr, start, end);
            }

            start++;
            end--;
        }

        return new String(arr);
    }

    private boolean isVowel(char c) {
        return VOWELS.contains(Character.toLowerCase(c));
    }

    private void swap(char[] arr, int start, int end) {
        char temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
