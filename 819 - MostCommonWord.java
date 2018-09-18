/*
https://leetcode.com/problems/most-common-word/

Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
Words in the list of banned words are given in lowercase, and free of punctuation.
Words in the paragraph are not case sensitive.  The answer is in lowercase.

Example:
Input:
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>();
        for (String s : banned) {
            bannedWords.add(s.toLowerCase());
        }

        paragraph = paragraph.toLowerCase().replaceAll("[^a-z\\s]", "").toLowerCase();
        String[] words = paragraph.split("\\s+");
        Map<String, Integer> wordCountMap = new HashMap<>();

        int max = 0;
        String commonWord = null;
        for (String s : words) {
            if (!bannedWords.contains(s)) {
                int cnt = wordCountMap.getOrDefault(s, 0) + 1;
                wordCountMap.put(s, cnt);
                if (cnt > max) {
                    max = cnt;
                    commonWord = s;
                }
            }
        }

        return commonWord;
    }
}
