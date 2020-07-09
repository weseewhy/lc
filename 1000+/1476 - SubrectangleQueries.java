/*
https://leetcode.com/problems/subrectangle-queries/

Implement the class SubrectangleQueries which receives a rows x cols rectangle 
as a matrix of integers in the constructor and supports two methods:
1) updateSubrectangle(int row1, int col1, int row2, int col2, int newValue):
    Updates all values with newValue in the subrectangle whose upper left coordinate 
    is (row1,col1) and bottom right coordinate is (row2,col2).
2) getValue(int row, int col):
    Returns the current value of the coordinate (row,col) from the rectangle.

Example 1:
Input
["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue",
"updateSubrectangle","getValue","getValue"]
[[[[1,2,1],[4,3,4],[3,2,1],[1,1,1]]],
[0,2],[0,0,3,2,5],[0,2],[3,1],[3,0,3,2,10],[3,1],[0,2]]

Output: [null,1,null,5,5,null,10,5]

Explanation
SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,2,1],[4,3,4],[3,2,1],[1,1,1]]);
// The initial rectangle (4x3) looks like:
// 1 2 1
// 4 3 4
// 3 2 1
// 1 1 1
subrectangleQueries.getValue(0, 2); // return 1
subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5);
// After this update the rectangle looks like:
// 5 5 5
// 5 5 5
// 5 5 5
// 5 5 5
subrectangleQueries.getValue(0, 2); // return 5
subrectangleQueries.getValue(3, 1); // return 5
subrectangleQueries.updateSubrectangle(3, 0, 3, 2, 10);
// After this update the rectangle looks like:
// 5   5   5
// 5   5   5
// 5   5   5
// 10  10  10
subrectangleQueries.getValue(3, 1); // return 10
subrectangleQueries.getValue(0, 2); // return 5
*/

import java.util.Deque;
import java.util.LinkedList;

class SubrectangleQueries {
    private final int[][] rectangle;
    private final Deque<int[]> history;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = new int[rectangle.length][];
        for (int i = 0; i < rectangle.length; i++) {
            this.rectangle[i] = rectangle[i].clone();
        }
        this.history = new LinkedList<>();
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        this.history.addFirst(new int[]{row1, row2, col1, col2, newValue});
    }

    public int getValue(int row, int col) {
        for (int[] h : this.history) {
            if (h[0] <= row && row <= h[1] && h[2] <= col && col <= h[3]) {
                return h[4];
            }
        }
        return this.rectangle[row][col];
    }
}
