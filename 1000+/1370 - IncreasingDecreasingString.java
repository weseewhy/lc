/*
https://leetcode.com/problems/increasing-decreasing-string/

Given a string s. You should re-order the string using the following algorithm:
    1) Pick the smallest character from s and append it to the result.
    2) Pick the smallest character from s which is greater than the last appended character to the result and append it.
    3) Repeat step 2 until you cannot pick more characters.
    4) Pick the largest character from s and append it to the result.
    5) Pick the largest character from s which is smaller than the last appended character to the result and append it.
    6) Repeat step 5 until you cannot pick more characters.
    7) Repeat the steps from 1 to 6 until you pick all characters from s.
In each step, If the smallest or the largest character appears more than once you can choose any occurrence and append it to the result.
Return the result string after sorting s with this algorithm.

Example 1:
Input: s = "aaaabbbbcccc"
Output: "abccbaabccba"
Explanation: After steps 1, 2 and 3 of the first iteration, result = "abc"
After steps 4, 5 and 6 of the first iteration, result = "abccba"
First iteration is done. Now s = "aabbcc" and we go back to step 1
After steps 1, 2 and 3 of the second iteration, result = "abccbaabc"
After steps 4, 5 and 6 of the second iteration, result = "abccbaabccba"

Example 2:
Input: s = "rat"
Output: "art"

Example 3:
Input: s = "leetcode"
Output: "cdelotee"

Example 4:
Input: s = "ggggggg"
Output: "ggggggg"

Example 5:
Input: s = "spo"
Output: "ops"
*/

class Solution {
    public String sortString(String s) {
        int[] chars = new int[26];

        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        int diff = 1;
        while (sb.length() < s.length()) {
            int cnt = chars[index];
            if (cnt > 0) {
                sb.append((char) ('a' + index));
                chars[index]--;
            }
            index += diff;
            if (index > 25) {
                index = 25;
                diff = -1;
            } else if (index < 0) {
                index = 0;
                diff = 1;
            }
        }

        return sb.toString();
    }
}
