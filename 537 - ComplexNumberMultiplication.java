/*
https://leetcode.com/problems/complex-number-multiplication/

Given two strings representing two complex numbers.
You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

Example 1:
Input: "1+1i", "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.

Example 2:
Input: "1+-1i", "1+-1i"
Output: "0+-2i"
Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.

Note:
The input strings will not have extra blank.
The input strings will be given in the form of a+bi, where the integer a and b will both belong 
to the range of [-100, 100]. And the output should be also in this form.
*/

class Solution {
    public String complexNumberMultiply(String a, String b) {
        int[] num1 = parseComplexNumber(a);
        int[] num2 = parseComplexNumber(b);

        int real = num1[0] * num2[0] - num1[1] * num2[1];
        int img = num1[1] * num2[0] + num2[1] * num1[0];

        return String.format("%d+%di", real, img);
    }

    private int[] parseComplexNumber(String a) {
        int[] out = new int[2];
        String[] splits = a.split("\\+");
        out[0] = Integer.valueOf(splits[0]);
        out[1] = Integer.valueOf(splits[1].replace("i", ""));
        return out;
    }
}
