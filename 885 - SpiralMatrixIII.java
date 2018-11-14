/*
https://leetcode.com/problems/spiral-matrix-iii/

On a 2 dimensional grid with R rows and C columns, we start at (r0, c0) facing east.
Now, we walk in a clockwise spiral shape to visit every position in this grid. 

Whenever we would move outside the boundary of the grid, we continue our walk outside the grid 
(but may return to the grid boundary later.) Eventually, we reach all R * C spaces of the grid.

Return a list of coordinates representing the positions of the grid in the order they were visited.

Example 1:
Input: R = 1, C = 4, r0 = 0, c0 = 0
Output: [[0,0],[0,1],[0,2],[0,3]]

Example 2:
Input: R = 5, C = 6, r0 = 1, c0 = 4
Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],
         [0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]
*/

class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] out = new int[rows * cols][2];
        out[0] = new int[]{rStart, cStart};

        int dist = 0;
        State cur = new State(rStart, cStart);
        Bounds bounds = new Bounds(rows, cols);
        Direction direction = Direction.RIGHT;

        while (cur.size < rows * cols) {
            if (direction == Direction.RIGHT || direction == Direction.LEFT) {
                dist++;
            }

            move(cur, direction, dist, bounds, out);
            direction = direction.next();
        }

        return out;
    }

    private void move(State cur, Direction direction, int distance, Bounds bounds, int[][] out) {
        for (int i = 0; i < distance; i++) {
            moveOneStep(cur, direction);
            if (withinBounds(cur, bounds)) {
                savePoint(cur, out);
            }
        }
    }

    private boolean withinBounds(State state, Bounds bounds) {
        return state.row >= 0 && state.col >= 0 && state.row < bounds.maxRows && state.col < bounds.maxCols;
    }

    private void savePoint(State cur, int[][] out) {
        out[cur.size] = cur.getPoint();
        cur.size++;
    }

    private void moveOneStep(State state, Direction direction) {
        switch (direction) {
            case RIGHT:
                state.col++;
                break;
            case DOWN:
                state.row++;
                break;
            case LEFT:
                state.col--;
                break;
            case TOP:
                state.row--;
                break;
        }
    }
}

enum Direction {
    RIGHT,
    DOWN,
    LEFT,
    TOP;

    Direction next() {
        return Direction.values()[(this.ordinal() + 1) % 4];
    }
}

class Bounds {
    int maxRows;
    int maxCols;

    Bounds(int maxRows, int maxCols) {
        this.maxRows = maxRows;
        this.maxCols = maxCols;
    }
}

class State {
    int row;
    int col;
    int size;

    State(int row, int col) {
        this.row = row;
        this.col = col;
        this.size = 1;
    }

    int[] getPoint() {
        return new int[]{row, col};
    }
}
