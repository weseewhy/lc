/*
https://leetcode.com/problems/move-zeroes

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Example:
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

public class MoveZeroes {

    public int[] moveZeroes(int[] input) {
        int zeroIndex = 0;
        while (zeroIndex < input.length && input[zeroIndex] != 0) {
            zeroIndex++;
        }

        if (zeroIndex < input.length) {
            int cur = zeroIndex + 1;
            while (cur < input.length) {
                if (input[cur] != 0) {
                    input[zeroIndex] = input[cur];
                    input[cur] = 0;
                    zeroIndex++;
                }
                cur++;
            }
        }

        return input;
    }
}
