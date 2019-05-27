/*
Given a string, your task is to count how many palindromic substrings in this string.
The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
*/

class Solution {

    public int countSubstrings(String s) {
        int cnt = 0;
        // For each possible end index, check number of substrings ending at that index
        for (int right = 0; right < s.length(); right++) {
            for (int left = right; left >= 0; left--) {
                if (left == right || isPalindrome(s, left, right)) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }

        return true;
    }

    // Problem with previous approach is that we are re-calculating isPalindrome for each substring

    /**************************************************************/
    /******************** DYNAMIC PROGRAMMING *********************/
    /**************************************************************/
    public int countSubstrings_dp(String s) {
        int cnt = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int right = 0; right < s.length(); right++) {
            for (int left = right; left >= 0; left--) {
                if (left == right) {
                    // substring of length 1 is palindrome
                    dp[left][right] = true;
                } else {
                    // Check if chars at left & right are equal
                    dp[left][right] = s.charAt(left) == s.charAt(right);

                    // If end chars equal, then check for substring between left & right (if exists)
                    if (dp[left][right] && right - left > 1) {
                        dp[left][right] &= dp[left + 1][right - 1];
                    }
                }

                if (dp[left][right]) cnt++;
            }
        }

        return cnt;
    }
}

/*
dp[i][j]  --> Substring between i and j (included) is a palindrome

dp[i][j] = true   when i=j
         = S[i] == S[j] (chars at ends must be equal)
           && dp[i-1][j+1] = true (if a substring exists between i & j, it must be a palindrome)
 */
