/*
https://leetcode.com/problems/valid-boomerang/

A boomerang is a set of 3 points that are all distinct and not in a straight line.
Given a list of three points in the plane, return whether these points are a boomerang.

Example 1:
Input: [[1,1],[2,3],[3,2]]
Output: true

Example 2:
Input: [[1,1],[2,2],[3,3]]
Output: false

Example 3:
Input: [[0,0],[0,2],[2,1]]
Output: false

Example 4:
Input: [[0,1],[0,1],[2,1]]
Output: false
*/

class Solution {
    public boolean isBoomerang(int[][] points) {
        // Slope (y2-y1)/(x2-x1) should be different
        // To handle case when denominator is 0, do following (ex: 3)
        // Also handles duplicate points (ex: 4)
        return (points[1][1] - points[0][1]) * (points[2][0] - points[0][0])
            != (points[2][1] - points[0][1]) * (points[1][0] - points[0][0]);
    }
}
