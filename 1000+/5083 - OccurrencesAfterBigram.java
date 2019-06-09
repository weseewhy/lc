/*
https://leetcode.com/problems/occurrences-after-bigram/

Given words first and second, consider occurrences in some text of the form "first second third", 
where second comes immediately after first, and third comes immediately after second.
For each such occurrence, add "third" to the answer, and return the answer.

Example 1:
Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
Output: ["girl","student"]

Example 2:
Input: text = "we will we will rock you", first = "we", second = "will"
Output: ["we","rock"]
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> out = new ArrayList<>();
        String[] splits = text.split("\\s+");
        for (int i = 2; i < splits.length; i++) {
            if (splits[i - 1].equals(second) && splits[i - 2].equals(first)) {
                out.add(splits[i]);
            }
        }

        return out.toArray(new String[0]);
    }
}
