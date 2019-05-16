/*
https://leetcode.com/problems/number-of-matching-subsequences/

Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.

Example :
Input:
S = "abcde"
words = ["a", "bb", "acd", "ace"]
Output: 3
Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".

Note:
All words in words and S will only consists of lowercase letters.
The length of S will be in the range of [1, 50000].
The length of words will be in the range of [1, 5000].
The length of words[i] will be in the range of [1, 50].
*/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        // Map to hold words grouped by char they are expecting next
        Map<Character, Queue<Word>> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c, new LinkedList<>());
        }

        // To start with, all words will expect their first char first
        for (String s : words) {
            map.get(s.charAt(0)).offer(new Word(s));
        }

        int total = 0;
        // Iterate through all chars in string
        // For all the words expecting this char, will advance to next char (since this char matched)
        // Place the word into appropriate bucket based on next char they are expecting
        // If there is nothing to expect, then it's a full match.
        for (char c : S.toCharArray()) {
            int cnt = map.get(c).size();

            for (int i = 0; i < cnt; i++) {
                Word w = map.get(c).poll();
                w.accept();
                if (w.hasMore()) {
                    map.get(w.getChar()).offer(w);
                } else {
                    total++;
                }
            }
        }

        return total;
    }
}

class Word {
    private String s;
    private int index;

    Word(String s) {
        this.s = s;
        this.index = 0;
    }

    void accept() {
        index++;
    }

    boolean hasMore() {
        return index < s.length();
    }

    char getChar() {
        return s.charAt(index);
    }
}
