/*
https://leetcode.com/problems/reformat-the-string/

Given alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).
You have to find a permutation of the string where no letter is followed by another letter and no digit is followed by another digit. 
That is, no two adjacent characters have the same type.
Return the reformatted string or return an empty string if it is impossible to reformat the string.

Example 1:
Input: s = "a0b1c2"
Output: "0a1b2c"
Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid permutations.

Example 2:
Input: s = "leetcode"
Output: ""
Explanation: "leetcode" has only characters so we cannot separate them by digits.

Example 3:
Input: s = "1229857369"
Output: ""
Explanation: "1229857369" has only digits so we cannot separate them by characters.

Example 4:
Input: s = "covid2019"
Output: "c2o0v1i9d"

Example 5:
Input: s = "ab123"
Output: "1a2b3"
*/

class Solution {
    public String reformat(String s) {
        StringBuilder chars = new StringBuilder();
        StringBuilder nums = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                chars.append(c);
            } else {
                nums.append(c);
            }
        }

        if (Math.abs(chars.length() - nums.length()) > 1) {
            return "";
        }

        StringBuilder out = new StringBuilder();
        StringBuilder first = chars.length() >= nums.length() ? chars : nums;
        StringBuilder other = first == chars ? nums : chars;

        int index = 0;
        while (index < other.length()) {
            out.append(first.charAt(index));
            out.append(other.charAt(index));
            index++;
        }
        if (index < first.length()) {
            out.append(first.charAt(index));
        }

        return out.toString();
    }
}
