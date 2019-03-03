/*
https://leetcode.com/problems/find-common-characters/

Given an array A of strings made only from lowercase letters,
return a list of all characters that show up in all strings within the list (including duplicates).  
For example, if a character occurs 3 times in all strings but not 4 times, 
you need to include that character three times in the final answer.

You may return the answer in any order.

Example 1:
Input: ["bella","label","roller"]
Output: ["e","l","l"]

Example 2:
Input: ["cool","lock","cook"]
Output: ["c","o"]
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> commonChars(String[] A) {
        int[] cnt = getCharCount(A[0]);

        for (int i = 1; i < A.length; i++) {
            int[] cur = getCharCount(A[i]);
            for (int j = 0; j < 26; j++) {
                cnt[j] = Math.min(cur[j], cnt[j]);
            }
        }

        List<String> out = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (cnt[i] > 0) {
                char c = (char) ('a' + i);
                out.add(String.valueOf(c));
                cnt[i]--;
            }
        }

        return out;
    }

    private int[] getCharCount(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a'] += 1;
        }

        return cnt;
    }
}
