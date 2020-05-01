/*
https://leetcode.com/problems/check-if-it-is-a-straight-line/

You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
Check if these points make a straight line in the XY plane.

Example 1:
Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true

Example 2:
Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
*/

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        for (int i = 2; i < coordinates.length; i++) {
            if (!line(coordinates[0], coordinates[1], coordinates[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean line(int[] p1, int[] p2, int[] p3) {
        /*
          (x1, y1)  (x2, y2)  (x3, y3)
          (y2-y1)/(x2-x1) = (y3-y1)/(x3-x1)
        */
        return (p2[1] - p1[1]) * (p3[0] - p1[0]) == (p3[1] - p1[1]) * (p2[0] - p1[0]);
    }
}

