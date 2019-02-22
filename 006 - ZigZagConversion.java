/*
https://leetcode.com/problems/zigzag-conversion/

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
(you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        numRows = Math.min(numRows, s.length());
        List<StringBuilder> list = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        int index = 0;
        int diff = 1;
        for (char c : s.toCharArray()) {
            list.get(index).append(c);
            if (index == 0) {
                diff = 1;
            } else if (index == numRows - 1) {
                diff = -1;
            }

            index += diff;
        }

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            out.append(list.get(i));
        }

        return out.toString();
    }
}
