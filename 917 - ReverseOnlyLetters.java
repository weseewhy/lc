/*
https://leetcode.com/problems/reverse-only-letters/

Given a string S, return the "reversed" string where all characters that are not 
a letter stay in the same place, and all letters reverse their positions.

Example 1:
Input: "ab-cd"
Output: "dc-ba"

Example 2:
Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"

Example 3:
Input: "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
*/

class Solution {
    public String reverseOnlyLetters(String S) {
        int i = 0;
        int j = S.length() - 1;
        char[] chars = S.toCharArray();

        while (i < j) {
            while (i < j && !Character.isAlphabetic(S.charAt(i))) {
                i++;
            }

            while (i < j && !Character.isAlphabetic(S.charAt(j))) {
                j--;
            }

            if (i < j) {
                swap(chars, i, j);
            }

            i++;
            j--;
        }

        return new String(chars);
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
