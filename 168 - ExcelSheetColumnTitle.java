/*
https://leetcode.com/problems/excel-sheet-column-title/

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
    ...

Input: 1
Output: "A"

Input: 28
Output: "AB"

Input: 701
Output: "ZY"
*/

class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n = n - 1;
            sb.append(getChar(n % 26));
            n = n / 26;
        }

        return sb.reverse().toString();
    }

    private char getChar(int i) {
        return (char) ('A' + i);
    }
}
