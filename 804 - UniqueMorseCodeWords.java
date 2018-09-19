/*
https://leetcode.com/problems/unique-morse-code-words/

International Morse Code defines a standard encoding where each letter is mapped to a series of 
dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. 
For example, "cab" can be written as "-.-.-....-", (which is the concatenation "-.-." + "-..." + ".-"). 
We'll call such a concatenation, the transformation of a word.

Return the number of different transformations among all words we have.

Example:
Input: words = ["gin", "zen", "gig", "msg"]
Output: 2
Explanation: 
The transformation of each word is:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."

There are 2 different transformations, "--...-." and "--...--.".
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    private final List<String> list = Arrays.asList(
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.",
            "---", ".--.", "--.-", ".-.", "...", "-", "..-",
            "...-", ".--", "-..-", "-.--", "--..");

    public int uniqueMorseRepresentations(String[] words) {

        Set<String> codes = new HashSet<>();
        for (String w : words) {
            codes.add(getCode(w));
        }

        return codes.size();
    }

    private String getCode(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            sb.append(list.get(c - 'a'));
        }
        return sb.toString();
    }
}
