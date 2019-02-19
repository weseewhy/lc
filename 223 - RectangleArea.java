/*
https://leetcode.com/problems/rectangle-area/

Find the total area covered by two rectilinear rectangles in a 2D plane.
Each rectangle is defined by its bottom left corner and top right corner.

Example:
Input: [(-3,0), (3,4)], [(0,-1), (9,2)]
Output: 45
*/

class Solution {
    public int computeArea(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        int a1 = areaOfRectangle(x1, y1, x2, y2);
        int a2 = areaOfRectangle(x3, y3, x4, y4);
        int common = overLappingDistance(x1, x2, x3, x4) * overLappingDistance(y1, y2, y3, y4);
        return a1 + a2 - common;
    }

    private int areaOfRectangle(int x1, int y1, int x2, int y2) {
        return Math.abs((x1 - x2) * (y1 - y2));
    }

    private int overLappingDistance(int p1, int p2, int p3, int p4) {
        if (p2 <= p3 || p4 <= p1) {
            return 0;
        }

        return Math.min(p2, p4) - Math.max(p1, p3);
    }
}
