/*
https://leetcode.com/problems/largest-number/

Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:
Input: [10,2]
Output: "210"

Example 2:
Input: [3,30,34,5,9]
Output: "9534330"

Example 3:
Input: [0, 0]
Output: "0"
*/

import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        String s = Arrays.stream(nums)
                .boxed()
                .map(String::valueOf)
                .sorted((i, j) -> (j + i).compareTo(i + j))
                .reduce("", String::concat);

        return s.charAt(0) == '0' ? "0" : s;
    }
}
