/*
https://leetcode.com/problems/squares-of-a-sorted-array/

Given an array of integers A sorted in non-decreasing order,
return an array of the squares of each number, also in sorted non-decreasing order.

Example 1:
Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]

Example 2:
Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]
*/

class Solution {
    public int[] sortedSquares(int[] arr) {
        int ni = -1;
        for (int i : arr) {
            if (i < 0) {
                ni++;
            } else {
                break;
            }
        }

        int pi = ni + 1;
        int[] out = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (inBounds(arr.length, pi) && inBounds(arr.length, ni)) {
                if (Math.abs(arr[pi]) <= Math.abs(arr[ni])) {
                    out[i] = arr[pi] * arr[pi];
                    pi++;
                } else {
                    out[i] = arr[ni] * arr[ni];
                    ni--;
                }
            } else if (inBounds(arr.length, pi)) {
                out[i] = arr[pi] * arr[pi];
                pi++;
            } else {
                out[i] = arr[ni] * arr[ni];
                ni--;
            }
        }

        return out;
    }

    private boolean inBounds(int high, int i) {
        return i >= 0 && i < high;
    }
}
