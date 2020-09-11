/*
https://leetcode.com/problems/letter-tile-possibilities/

You have n  tiles, where each tile has one letter tiles[i] printed on it.
Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.

Example 1:
Input: tiles = "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".

Example 2:
Input: tiles = "AAABBC"
Output: 188

Example 3:
Input: tiles = "V"
Output: 1

Constraints:
    . 1 <= tiles.length <= 7
    . tiles consists of uppercase English letters.
*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public int numTilePossibilities(String s) {
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c - 'A']++;
        }
        return dfs(chars);
    }

    private int dfs(int[] chars) {
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 0) continue;

            sum++;
            chars[i]--;
            sum += dfs(chars);
            chars[i]++;
        }

        return sum;
    }

    /*****************************************************/

    public List<String> generateAllCombinations(String s) {
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c - 'A']++;
        }
        List<String> out = new ArrayList<>();
        dfs(chars, new StringBuilder(), out);
        return out;
    }

    private void dfs(int[] chars, StringBuilder path, List<String> out) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 0) continue;

            path.append((char) ('A' + i));
            // If we want combinations with all chars from input,
            // we can add it to out only when len(path) == len(input)
            out.add(path.toString());

            chars[i]--;
            dfs(chars, path, out);
            chars[i]++;
        }
    }
}
