/*
https://leetcode.com/problems/base-7/

Given an integer, return its base 7 string representation.

Example 1:
Input: 100
Output: "202"

Example 2:
Input: -7
Output: "-10"
*/

public class Base7 {
    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        boolean isNegative = num < 0;
        num = Math.abs(num);

        int rem;
        while (num > 0) {
            rem = num % 7;
            num = num / 7;
            sb.insert(0, rem);
        }

        if (isNegative) {
            sb.insert(0, "-");
        } else if (sb.length() == 0) {
            sb.append("0");
        }

        return sb.toString();
    }
}
