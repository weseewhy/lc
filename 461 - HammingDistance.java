/*
https://leetcode.com/problems/hamming-distance/

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
Given two integers x and y, calculate the Hamming distance.

Example:
Input: x = 1, y = 4
Output: 2
Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
The above arrows point to positions where the corresponding bits are different.
*/

class Solution {
    public int hammingDistance(int x, int y) {
        int dist = 0;
        int xy = x ^ y;
        while (xy > 0) {
            if ((xy & 1) == 1) {
                dist++;
            }
            xy = xy >> 1;
        }

        return dist;
    }
}
