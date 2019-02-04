/*
https://leetcode.com/problems/interval-list-intersections/

Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  
The intersection of two closed intervals is a set of real numbers that is either empty, 
or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

Example 1:
Input: 
   A = [[0,2],[5,10],[13,23],[24,25]], 
   B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        List<Interval> out = new ArrayList<>();
        int a = 0;
        int b = 0;

        while (a < A.length && b < B.length) {
            Interval ia = A[a];
            Interval ib = B[b];

            if (ia.isBefore(ib)) {
                a++;
            } else if (ia.isAfter(ib)) {
                b++;
            } else {
                out.add(ia.findOverLap(ib));
                if (ia.end < ib.end) {
                    a++;
                } else {
                    b++;
                }
            }
        }

        return out.toArray(new Interval[0]);
    }
}

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    boolean isBefore(Interval other) {
        return this.end < other.start;
    }

    boolean isAfter(Interval other) {
        return this.start > other.end;
    }

    boolean overlaps(Interval other) {
        return !isBefore(other) && !(isAfter(other));
    }

    Interval findOverLap(Interval other) {
        if (!overlaps(other)) {
            return null;
        }

        return new Interval(Math.max(this.start, other.start), Math.min(this.end, other.end));
    }
}
