/*
https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/

Given a string s containing only lower case English letters and the '?' character, 
convert all the '?' characters into lower case letters such that the final string does 
not contain any consecutive repeating characters. You cannot modify the non '?' characters.
It is guaranteed that there are no consecutive repeating characters in the given string except for '?'.

Return the final string after all the conversions (possibly zero) have been made. 
If there is more than one solution, return any of them. 
It can be shown that an answer is always possible with the given constraints.

Example 1:
Input: s = "?zs"
Output: "azs"
Explanation: There are 25 solutions for this problem. From "azs" to "yzs", all are valid. 
Only "z" is an invalid modification as the string will consist of consecutive repeating characters in "zzs".

Example 2:
Input: s = "ubv?w"
Output: "ubvaw"
Explanation: There are 24 solutions for this problem. Only "v" and "w" are invalid 
modifications as the strings will consist of consecutive repeating characters in "ubvvw" and "ubvww".

Example 3:
Input: s = "j?qg??b"
Output: "jaqgacb"

Example 4:
Input: s = "??yw?ipkj?"
Output: "acywaipkja"

Constraints:
    . 1 <= s.length <= 100
    . s contains only lower case English letters and '?'.
*/

class Solution {
    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (okay(chars, c, i - 1) && okay(chars, c, i + 1)) {
                        chars[i] = c;
                        break;
                    }
                }
            }
        }

        return new String(chars);
    }

    private boolean okay(char[] chars, char c, int index) {
        if (index < 0 || index >= chars.length || chars[index] == '?') {
            return true;
        }

        return Math.abs(chars[index] - c) > 0;
    }
}
