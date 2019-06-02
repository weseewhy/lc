/*
https://leetcode.com/problems/greatest-common-divisor-of-strings/

For strings S and T, we say "T divides S" if and only if S = T + ... + T  (T concatenated with itself 1 or more times)
Return the largest string X such that X divides str1 and X divides str2.

Example 1:
Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"

Example 2:
Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"

Example 3:
Input: str1 = "LEET", str2 = "CODE"
Output: ""
*/

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String small = str1.length() <= str2.length() ? str1 : str2;
        String big = str2.length() >= str1.length() ? str2 : str1;

        // If x is the gcd, then
        // small = xx
        // big   = xxxxx
        for (int i = 0; i < small.length(); i++) {
            if (small.charAt(i) != big.charAt(i)) {
                return "";
            }
        }

        if (small.length() == big.length()) {
            return small;
        }

        return gcdOfStrings(small, big.substring(small.length()));
    }
}

/*
For a>b, gcd(a,b) = gcd(b, a-b)
*/
