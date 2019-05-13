/*
https://leetcode.com/problems/robot-bounded-in-circle/

On an infinite plane, a robot initially stands at (0, 0) and faces north.
The robot can receive one of three instructions:
    "G": go straight 1 unit;
    "L": turn 90 degrees to the left;
    "R": turn 90 degress to the right.
The robot performs the instructions given in order, and repeats them forever.
Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

Example 1:
Input: "GGLLGG"
Output: true
Explanation:
The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.

Example 2:
Input: "GG"
Output: false
Explanation: The robot moves north indefinitely.

Example 3:
Input: "GL"
Output: true
Explanation: The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
*/

class Solution {
    public boolean isRobotBounded(String instructions) {
        Robot robot = new Robot();
        for (char c : instructions.toCharArray()) {
            robot.move(c);
        }

        return (robot.x == 0 && robot.y == 0) || robot.dir != Direction.UP;
    }
}

class Robot {
    Direction dir = Direction.UP;
    int x = 0;
    int y = 0;

    void move(char c) {
        if (c == 'G') {
            this.x += dir.x;
            this.y += dir.y;
        } else {
            int diff = c == 'L' ? 1 : c == 'R' ? 3 : 0;
            this.dir = Direction.values()[(this.dir.ordinal() + diff) % 4];
        }
    }
}

enum Direction {
    UP(0, 1),
    LEFT(-1, 0),
    DOWN(0, -1),
    RIGHT(1, 0);

    int x, y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
