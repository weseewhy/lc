/*
https://leetcode.com/problems/positions-of-large-groups/

In a string S of lowercase letters, these letters form consecutive groups of the same character.
For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.
The final answer should be in lexicographic order.

Example 1:
Input: "abbxxxxzzy"
Output: [[3,6]]
Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.

Example 2:
Input: "abc"
Output: []
Explanation: We have "a","b" and "c" but no large group.

Example 3:
Input: "abcdddeeeeaabbbcd"
Output: [[3,5],[6,9],[12,14]]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> out = new ArrayList<>();

        int start = 0;
        int cur = start + 1;
        int len = 1;

        while (cur < S.length()) {
            if (S.charAt(cur) == S.charAt(start)) {
                len++;
            } else {
                if (len >= 3) {
                    out.add(Arrays.asList(start, cur - 1));
                }
                len = 1;
                start = cur;
            }
            cur++;
        }

        if (len >= 3) {
            out.add(Arrays.asList(start, cur - 1));
        }

        return out;
    }
}
