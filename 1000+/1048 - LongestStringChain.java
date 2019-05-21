/*
https://leetcode.com/problems/longest-string-chain/

Given a list of words, each word consists of English lowercase letters.
Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make it equal to word2.  
For example, "abc" is a predecessor of "abac".

A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, 
where word_1 is a predecessor of word_2, word_2 is a predecessor of word_3, and so on.

Return the longest possible length of a word chain with words chosen from the given list of words.

Example 1:
Input: ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: one of the longest word chain is "a","ba","bda","bdca".
*/

import java.util.*;

class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Map<String, Integer> chain = new HashMap<>();

        int res = 0;
        for (String s : words) {
            if (chain.containsKey(s)) continue;
            int max = 0;
            // For each string, generate all possible predecessors
            // If the pre exists, current word will increment it's chain length by 1
            for (int i = 0; i < s.length(); i++) {
                StringBuilder sb = new StringBuilder(s);
                sb.deleteCharAt(i);
                int preLength = chain.getOrDefault(sb.toString(), 0);
                max = Math.max(max, preLength);
            }

            chain.put(s, max + 1);
            res = Math.max(res, chain.get(s));
        }

        return res;
    }

    // Instead of generating all predecessors, compare each string of length 'n'
    // with string of length 'n-1'. If it is predecessor, increase corresponding chain length
    public int longestStrChain_2(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Map<Integer, Set<String>> map = new HashMap<>();
        for (String s : words) {
            map.putIfAbsent(s.length(), new HashSet<>());
            map.get(s.length()).add(s);
        }

        Map<String, Integer> chain = new HashMap<>();
        for (String s : map.get(words[0].length())) {
            chain.put(s, 1);
        }

        int res = 1;
        for (String w : words) {
            if (chain.containsKey(w)) continue;

            int maxLengthForPredecessor = 0;
            for (String pre : map.get(w.length() - 1)) {
                if (isPredecessor(pre, w)) {
                    maxLengthForPredecessor = Math.max(chain.get(pre), maxLengthForPredecessor);
                }
            }

            chain.put(w, maxLengthForPredecessor + 1);
            res = Math.max(res, chain.get(w));
        }

        return res;
    }

    private boolean isPredecessor(String small, String big) {
        if (big.length() != small.length() + 1) {
            return false;
        }

        int i = 0, j = 0;
        boolean diff = false;
        while (i < small.length() && j < big.length()) {
            if (small.charAt(i) != big.charAt(j)) {
                if (diff) {
                    return false;
                } else {
                    diff = true;
                    j++;
                }
            } else {
                i++;
                j++;
            }
        }

        return true;
    }
}
