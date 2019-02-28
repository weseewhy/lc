/*
https://leetcode.com/problems/generate-random-point-in-a-circle/

Given the radius and x-y positions of the center of a circle,
write a function randPoint which generates a uniform random point in the circle.
*/

import java.util.Random;

class Solution {
    private double cX;
    private double cY;
    private double r;
    private Random random;

    public Solution(double radius, double x_center, double y_center) {
        this.r = radius;
        this.cX = x_center;
        this.cY = y_center;
        this.random = new Random();
    }

    public double[] randPoint() {
        // http://www.anderswallin.net/2009/05/uniform-random-points-in-a-circle-using-polar-coordinates/
        double dist = r * Math.sqrt(random.nextDouble());

        double theta = 2 * Math.PI * random.nextDouble();
        double x = cX + dist * Math.cos(theta);
        double y = cY + dist * Math.sin(theta);
        return new double[]{x, y};
    }
}
