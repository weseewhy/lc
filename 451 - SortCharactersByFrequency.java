/*
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:
Input: "tree"
Output: "eert"
Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:
Input: "cccaaa"
Output: "cccaaa"
Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:
Input: "Aabb"
Output: "bbAa"
Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String frequencySort(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        Map<Character, Integer> cntMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            cntMap.put(c, cntMap.getOrDefault(c, 0) + 1);
        }

        // Alternate approach is to use PriorityQueue
        Map<Integer, List<Character>> charMap = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : cntMap.entrySet()) {
            if (!charMap.containsKey(entry.getValue())) {
                charMap.put(entry.getValue(), new ArrayList<>());
            }

            charMap.get(entry.getValue()).add(entry.getKey());
        }

        StringBuilder sb = new StringBuilder();
        for (int freq = s.length(); freq > 0 && sb.length() < s.length(); freq--) {
            if (charMap.containsKey(freq)) {
                for (char c : charMap.get(freq)) {
                    for (int i = 0; i < freq; i++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }
}
