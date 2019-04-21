/*
https://leetcode.com/problems/matrix-cells-in-distance-order/

We are given a matrix with R rows and C columns has cells with integer coordinates (r, c), 
where 0 <= r < R and 0 <= c < C. Additionally, we are given a cell in that matrix with coordinates (r0, c0).

Return the coordinates of all cells in the matrix, sorted by their distance from (r0, c0) from smallest distance 
to largest distance.  Here, the distance between two cells (r1, c1) and (r2, c2) is the Manhattan distance, 
|r1 - r2| + |c1 - c2|. You may return the answer in any order that satisfies this condition.

Example 1:
Input: R = 1, C = 2, r0 = 0, c0 = 0
Output: [[0,0],[0,1]]
Explanation: The distances from (r0, c0) to other cells are: [0,1]

Example 2:
Input: R = 2, C = 2, r0 = 0, c0 = 1
Output: [[0,1],[0,0],[1,1],[1,0]]
Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2]
The answer [[0,1],[1,1],[0,0],[1,0]] would also be accepted as correct.

Example 3:
Input: R = 2, C = 3, r0 = 1, c0 = 2
Output: [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2,2,3]
There are other answers that would also be accepted as correct, such as [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]].
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        Point src = new Point(r0, c0);
        List<Point> points = new ArrayList<>(R * C);
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                points.add(new Point(row, col, src));
            }
        }

        points.sort(Comparator.comparing(p -> p.dist));
        int[][] out = new int[R * C][2];
        for (int i = 0; i < points.size(); i++) {
            out[i][0] = points.get(i).row;
            out[i][1] = points.get(i).col;
        }

        return out;
    }
}

class Point {
    int row;
    int col;
    int dist;

    Point(int row, int col) {
        this.row = row;
        this.col = col;
        this.dist = 0;
    }

    Point(int row, int col, Point src) {
        this.row = row;
        this.col = col;
        this.dist = Math.abs(src.row - this.row) + Math.abs(src.col - this.col);
    }

}
