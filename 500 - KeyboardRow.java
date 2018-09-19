/*
https://leetcode.com/problems/keyboard-row/

Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard

Example 1:
Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]
 */

import java.util.*;

public class KeyboardRow {
    private final Set<Character> row1 = new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
    private final Set<Character> row2 = new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
    private final Set<Character> row3 = new HashSet<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));

    public String[] findWords(String[] words) {
        List<String> out = new ArrayList<>();
        for (String word : words) {
            if (isSameRow(word)) {
                out.add(word);
            }
        }

        return out.toArray(new String[0]);
    }

    private boolean isSameRow(String word) {
        char c = Character.toLowerCase(word.charAt(0));
        Set<Character> row = row1.contains(c) ? row1 : row2.contains(c) ? row2 : row3;
        for (int i = 1; i < word.length(); i++) {
            if (!row.contains(Character.toLowerCase(word.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}
