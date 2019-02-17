/*
https://leetcode.com/problems/multiply-strings/

Given two non-negative integers num1 and num2 represented as strings,
return the product of num1 and num2, also represented as a string.

Example 1:
Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:
Input: num1 = "123", num2 = "456"
Output: "56088"
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String multiply(String a, String b) {
        if ("0".equals(a) || "0".equals(b)) {
            return "0";
        }

        List<List<Integer>> list = new ArrayList<>();
        for (int i = b.length() - 1; i >= 0; i--) {
            List<Integer> mulBySingle = new ArrayList<>();
            int numOfZeroes = (b.length() - 1 - i);
            while (numOfZeroes > 0) {
                mulBySingle.add(0);
                numOfZeroes--;
            }

            int cur = b.charAt(i) - '0';
            int carry = 0;
            int mul;
            for (int j = a.length() - 1; j >= 0; j--) {
                int other = a.charAt(j) - '0';
                mul = cur * other + carry;
                mulBySingle.add(mul % 10);
                carry = mul / 10;
            }

            if (carry > 0) {
                mulBySingle.add(carry);
            }

            list.add(mulBySingle);
        }

        return addRows(list);
    }

    private String addRows(List<List<Integer>> rows) {
        int numberOfDigits = 0;
        for (List<Integer> row : rows) {
            numberOfDigits = Math.max(row.size(), numberOfDigits);
        }

        List<Integer> out = new ArrayList<>();
        int carry = 0;
        for (int i = 0; i < numberOfDigits; i++) {
            int sum = carry;
            for (int j = 0; j < rows.size(); j++) {
                int rowDigit = i < rows.get(j).size() ? rows.get(j).get(i) : 0;
                sum += rowDigit;
            }

            out.add(sum % 10);
            carry = sum / 10;
        }

        while (carry > 0) {
            out.add(carry % 10);
            carry = carry / 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = out.size() - 1; i >= 0; i--) {
            sb.append(out.get(i));
        }

        return sb.toString();
    }
}
