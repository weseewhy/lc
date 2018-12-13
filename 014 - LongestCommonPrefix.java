/*
https://leetcode.com/problems/longest-common-prefix/

Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int prefixLength = strs[0].length();
        for (int i = 1; i < strs.length && prefixLength > 0; i++) {
            String cur = strs[i];
            prefixLength = Math.min(prefixLength, cur.length());

            for (int j = 0; j < prefixLength; j++) {
                if (cur.charAt(j) != strs[0].charAt(j)) {
                    prefixLength = j;
                    break;
                }
            }
        }

        return strs[0].substring(0, prefixLength);
    }
}
