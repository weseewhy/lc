/*
https://leetcode.com/problems/add-to-array-form-of-integer/

For a non-negative integer X, the array-form of X is an array of its digits in left to right order.  
For example, if X = 1231, then the array form is [1,2,3,1].
Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.

Example 1:
Input: A = [1,2,0,0], K = 34
Output: [1,2,3,4]
Explanation: 1200 + 34 = 1234

Example 2:
Input: A = [2,7,4], K = 181
Output: [4,5,5]
Explanation: 274 + 181 = 455

Example 3:
Input: A = [2,1,5], K = 806
Output: [1,0,2,1]
Explanation: 215 + 806 = 1021

Example 4:
Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
Output: [1,0,0,0,0,0,0,0,0,0,0]
Explanation: 9999999999 + 1 = 10000000000
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> out = new ArrayList<>();
        int carry = 0;

        for (int i = A.length - 1; i >= 0; i--) {
            int cur = A[i] + carry;
            if (K > 0) {
                cur += K % 10;
                K = K / 10;
            }

            out.add(cur % 10);
            carry = cur / 10;
        }

        while (K > 0) {
            int temp = K % 10;
            temp += carry;
            out.add(temp % 10);
            carry = temp / 10;
            K = K / 10;
        }

        if (carry > 0) {
            out.add(carry);
        }

        Collections.reverse(out);
        return out;
    }
}
