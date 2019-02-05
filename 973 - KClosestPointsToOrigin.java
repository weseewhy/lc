/*
https://leetcode.com/problems/k-closest-points-to-origin/

We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
You may return the answer in any order.
The answer is guaranteed to be unique (except for the order that it is in.)

Example 1:
Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

Example 2:
Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
*/

import java.util.PriorityQueue;

class Solution {

    // Better approach is to use "Selection" algorithm
    public int[][] kClosest(int[][] points, int k) {
        if (k >= points.length) {
            return points;
        }

        PriorityQueue<Point> queue = new PriorityQueue<>((p1, p2) -> p2.getDistance() - p1.getDistance());
        for (int[] arr : points) {
            Point cur = new Point(arr);
            if (queue.size() < k) {
                queue.add(cur);
            } else if (cur.getDistance() < queue.peek().getDistance()) {
                queue.poll();
                queue.add(cur);
            }
        }

        int[][] out = new int[k][2];
        for (int i = 0; i < k; i++) {
            out[i] = queue.poll().getArr();
        }

        return out;
    }
}

class Point {
    int x;
    int y;

    Point(int[] arr) {
        this.x = arr[0];
        this.y = arr[1];
    }

    int getDistance() {
        return this.x * this.x + this.y * this.y;
    }

    int[] getArr() {
        return new int[]{x, y};
    }
}
