/*
https://leetcode.com/problems/walking-robot-simulation/

A robot on an infinite grid starts at point (0, 0) and faces north.
he robot can receive one of three possible types of commands:
    . -2: turn left 90 degrees
    . -1: turn right 90 degrees
    . 1 <= x <= 9: move forward x units
Some of the grid squares are obstacles.
The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1])
If the robot would try to move onto them, the robot stays on the previous
grid square instead (but still continues following the rest of the route.)

Return the square of the MAXIMUM Euclidean distance that the robot will be from the origin.

Example 1:
Input: commands = [4,-1,3], obstacles = []
Output: 25
Explanation: robot will go to (3, 4)

Example 2:
Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
Output: 65
Explanation: robot will be stuck at (1, 4) before turning left and going to (1, 8)
*/

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Point> obs = new HashSet<>();
        for (int[] o : obstacles) {
            obs.add(new Point(o[0], o[1]));
        }

        int max = 0;
        Direction d = Direction.N;
        Point pos = new Point(0, 0);
        for (int val : commands) {
            if (val == -2) {
                d = d.left();
            } else if (val == -1) {
                d = d.right();
            } else {
                for (int j = 1; j <= val; j++) {
                    if (!move(pos, d, obs)) {
                        break;
                    }
                }
            }

            max = Math.max(max, pos.x * pos.x + pos.y * pos.y);
        }

        return max;
    }

    private boolean move(Point point, Direction d, Set<Point> obs) {
        int x = point.x;
        int y = point.y;
        switch (d) {
            case E: x++; break;
            case W: x--; break;
            case N: y++; break;
            case S: y--; break;
        }
        Point newPos = new Point(x, y);
        if (obs.contains(newPos)) {
            return false;
        }
        point.set(x, y);
        return true;
    }
}

enum Direction {
    N, E, S, W;

    public Direction left() {
        return Direction.values()[(this.ordinal() + 3) % 4];
    }

    public Direction right() {
        return Direction.values()[(this.ordinal() + 1) % 4];
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        set(x, y);
    }

    void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point that = (Point) o;
        return this.x == that.x && this.y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
