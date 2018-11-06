/*
https://leetcode.com/problems/shortest-completing-word/

Find the minimum length word from a given dictionary words, which has all the letters
from the string licensePlate. Such a word is said to complete the given string licensePlate

Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.
It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.
The license plate might have the same letter occurring multiple times. For example, given a licensePlate
of "PP", the word "pair" does not complete the licensePlate, but the word "supper" does.

Example 1:
Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
Output: "steps"
Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
Note that the answer is not "step", because the letter "s" must occur in the word twice.
Also note that we ignored case for the purposes of comparing whether a letter exists in the word.

Example 2:
Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
Output: "pest"
Explanation: There are 3 smallest length words that contains the letters "s".
We return the one that occurred first.

Note:
  - licensePlate will be a string with length in range [1, 7].
  - licensePlate will contain digits, spaces, or letters (uppercase or lowercase).
  - words will have a length in the range [10, 1000].
  - Every words[i] will consist of lowercase letters, and have length in range [1, 15].
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> plateMap = getCharCountMap(licensePlate);
        String match = null;
        for (String s : words) {
            if (matches(s, plateMap)) {
                match = match == null ? s : s.length() < match.length() ? s : match;
            }
        }
        return match;
    }

    private boolean matches(String word, Map<Character, Integer> plateMap) {
        Map<Character, Integer> wordMap = getCharCountMap(word);
        for (char c : plateMap.keySet()) {
            if (!wordMap.containsKey(c) || wordMap.get(c) < plateMap.get(c)) {
                return false;
            }
        }

        return true;
    }

    private Map<Character, Integer> getCharCountMap(String s) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c)) {
                char lowerCase = Character.toLowerCase(c);
                charCountMap.put(lowerCase, charCountMap.getOrDefault(lowerCase, 0) + 1);
            }
        }

        return charCountMap;
    }
}
