/*
https://leetcode.com/problems/vowel-spellchecker/

Given a wordlist, we want to implement a spellchecker that converts a query word into a correct word.
For a given query word, the spell checker handles two categories of spelling mistakes:

Capitalization: If the query matches a word in the wordlist (case-insensitive), 
then the query word is returned with the same case as the case in the wordlist.

Vowel Errors: If after replacing the vowels ('a', 'e', 'i', 'o', 'u') of the query word with any vowel individually, 
it matches a word in the wordlist (case-insensitive), then the query word is returned with the same case as the match in the wordlist.

In addition, the spell checker operates under the following precedence rules:
  - When the query exactly matches a word in the wordlist (case-sensitive), you should return the same word back.
  - When the query matches a word up to capitlization, you should return the first such match in the wordlist.
  - When the query matches a word up to vowel errors, you should return the first such match in the wordlist.
  - If the query has no matches in the wordlist, you should return the empty string.

Given some queries, return a list of words answer, where answer[i] is the correct word for query = queries[i].

Example 1:
Input: wordlist = ["KiTe","kite","hare","Hare"], 
       queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]
Output: ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> originalWords = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> lowerCaseWords = Stream.of(wordlist)
                .collect(Collectors.toMap(String::toLowerCase, Function.identity(), (first, second) -> first));
        Map<String, String> vowelIgnoredWords = Stream.of(wordlist)
                .collect(Collectors.toMap(this::maskVowels, Function.identity(), (first, second) -> first));

        String[] results = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String cur = queries[i];
            String match = "";

            if (originalWords.contains(cur)) {
                match = cur;
            }

            if (match.isEmpty()) {
                String lowerCaseWord = cur.toLowerCase();
                if (lowerCaseWords.containsKey(lowerCaseWord)) {
                    match = lowerCaseWords.get(lowerCaseWord);
                }
            }

            if (match.isEmpty()) {
                String vowelIgnoredWord = maskVowels(cur);
                if (vowelIgnoredWords.containsKey(vowelIgnoredWord)) {
                    match = vowelIgnoredWords.get(vowelIgnoredWord);
                }
            }

            results[i] = match;
        }

        return results;
    }

    private String maskVowels(String word) {
        StringBuilder sb = new StringBuilder(word.length());
        for (char c : word.toCharArray()) {
            sb.append(isVowel(c) ? "-" : c);
        }

        return sb.toString().toLowerCase();
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) > -1;
    }
}
