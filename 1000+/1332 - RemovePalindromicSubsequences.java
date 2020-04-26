/*
https://leetcode.com/problems/remove-palindromic-subsequences/

Given a string s consisting only of letters 'a' and 'b'. In a single step you can remove one 
palindromic subsequence from s. Return the minimum number of steps to make the given string empty.

Example 1:
Input: s = "ababa"
Output: 1

Example 2:
Input: s = "abb"
Output: 2
Explanation: "abb" -> "bb" -> "". 

Example 3:
Input: s = "baabb"
Output: 2
Explanation: "baabb" -> "b" -> "". 
Remove palindromic subsequence "baab" then "b".

Example 4:
Input: s = ""
Output: 0

Constraints:
    . 0 <= s.length <= 1000
    . s only consists of letters 'a' and 'b'
*/

class Solution {
    public int removePalindromeSub(String s) {
        if (s.length() == 0) {
            return 0;
        } else if (isPalindrome(s)) {
            return 1;
        } else {
            // remove all 'a's and then remove all 'b's
            return 2;
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
