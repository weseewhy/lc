/*
https://leetcode.com/problems/add-strings/

Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
*/
public class AddStrings {

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();

        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;

        int sum;
        int carry = 0;

        while (l1 >= 0 || l2 >= 0) {
            sum = carry;

            if (l1 >= 0) {
                sum += Character.getNumericValue(num1.charAt(l1));
                l1--;
            }

            if (l2 >= 0) {
                sum += Character.getNumericValue(num2.charAt(l2));
                l2--;
            }

            carry = sum / 10;
            sb.append(sum % 10);
        }

        if (carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
