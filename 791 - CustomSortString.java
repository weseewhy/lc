/*
https://leetcode.com/problems/custom-sort-string/

S and T are strings composed of lowercase letters. In S, no letter occurs more than once.
S was sorted in some custom order previously. We want to permute the characters of T so that 
they match the order that S was sorted. More specifically, if x occurs before y in S, t
hen x should occur before y in the returned string.

Return any permutation of T (as a string) that satisfies this property.

Example :
Input: 
S = "cba", T = "abcd"
Output: "cbad"
Explanation: 
"a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a". 
Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String customSortString(String S, String T) {
        StringBuilder distinct = new StringBuilder();
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : T.toCharArray()) {
            if (S.indexOf(c) < 0) {
                distinct.append(c);
            } else {
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
        }

        StringBuilder out = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (charCount.containsKey(c)) {
                for (int i = 0; i < charCount.get(c); i++) {
                    out.append(c);
                }
            }
        }

        out.append(distinct);
        return out.toString();
    }
}
