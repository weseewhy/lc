/*
https://leetcode.com/problems/uncommon-words-from-two-sentences/

We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
Return a list of all uncommon words.
You may return the list in any order.

Example 1:
Input: A = "this apple is sweet", B = "this apple is sour"
Output: ["sweet","sour"]

Example 2:
Input: A = "apple apple", B = "banana"
Output: ["banana"]
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String a, String b) {
        Map<String, Integer> wordCount = new HashMap<>();
        populateCountMap(a, wordCount);
        populateCountMap(b, wordCount);

        List<String> out = new ArrayList<>();
        for (String word : wordCount.keySet()) {
            if (wordCount.get(word) == 1) {
                out.add(word);
            }
        }

        return out.toArray(new String[0]);
    }

    private static void populateCountMap(String str, Map<String, Integer> wordCount) {
        for (String word : str.split("\\s+")) {
            int cnt = wordCount.getOrDefault(word, 0);
            wordCount.put(word, cnt + 1);
        }
    }
}
