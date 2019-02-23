/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons). Note that 1 does not map to any letters.

Example:
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private Map<Integer, String> phoneMap = getPhoneMap();

    public List<String> letterCombinations(String digits) {
        List<String> out = new ArrayList<>();
        if (digits.length() > 0) {
            generate(digits, 0, new StringBuilder(), out);
        }
        return out;
    }

    private void generate(String digits, int index, StringBuilder sb, List<String> out) {
        if (index == digits.length()) {
            out.add(sb.toString());
            return;
        }

        int curDigit = digits.charAt(index) - '0';
        for (char c : phoneMap.get(curDigit).toCharArray()) {
            sb.append(c);
            generate(digits, index + 1, sb, out);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private Map<Integer, String> getPhoneMap() {
        Map<Integer, String> map = new HashMap<>();
        StringBuilder sb;
        int charIndex = 0;
        for (int i = 2; i <= 9; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < (i == 7 || i == 9 ? 4 : 3); j++) {
                sb.append((char) ('a' + charIndex++));
            }
            map.put(i, sb.toString());
        }

        return map;
    }
}
