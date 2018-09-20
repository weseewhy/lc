/*
https://leetcode.com/problems/count-and-say/

The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1        --> read off as "one 1" or 11.
2.     11       --> read off as "two 1s" or 21.
3.     21       --> read off as "one 2, then one 1" or 1211.
4.     1211
5.     111221

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
Note: Each term of the sequence of integers will be represented as a string.

Example 1:
Input: 1
Output: "1"

Example 2:
Input: 4
Output: "1211"
*/

class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 2; i <= n; i++) {
            s = say(s);
        }

        return s;
    }

    private String say(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            int cnt = 1;
            while (i + 1 < s.length() && cur == s.charAt(i + 1)) {
                cnt++;
                i++;
            }
            sb.append(cnt).append(cur);
        }

        return sb.toString();
    }
}
