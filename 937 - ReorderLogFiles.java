/*
https://leetcode.com/problems/reorder-log-files/

You have an array of logs.  Each log is a space delimited string of words.
For each log, the first word in each log is an alphanumeric identifier.  Then, either:
    - Each word after the identifier will consist only of lowercase letters, or;
    - Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  
It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  
The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  
The digit-logs should be put in their original order.
Return the final order of the logs.

Example 1:
Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> digitLogs = new ArrayList<>();
        List<String> letterLogs = new ArrayList<>();

        for (String s : logs) {
            if (isDigitLog(s)) {
                digitLogs.add(s);
            } else {
                letterLogs.add(s);
            }
        }

        letterLogs.sort((s1, s2) -> {
            int val = s1.substring(s1.indexOf(" ") + 1).compareTo(s2.substring(s2.indexOf(" ") + 1));
            if (val != 0) {
                return val;
            } else {
                return s1.compareTo(s2);
            }
        });

        letterLogs.addAll(digitLogs);
        return letterLogs.toArray(new String[]{});
    }

    private boolean isDigitLog(String s) {
        return Character.isDigit(s.charAt(s.indexOf(" ") + 1));
    }
}
