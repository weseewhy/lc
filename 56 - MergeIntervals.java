/*
https://leetcode.com/problems/merge-intervals/

Given a collection of intervals, merge all overlapping intervals.

Example 1:
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:
Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }

        intervals.sort(new IntervalComparator());
        List<Interval> out = new ArrayList<>();
        Interval prev = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (intervalsOverlap(prev, cur)) {
                cur = new Interval(prev.start, Math.max(prev.end, cur.end));
            } else {
                out.add(prev);
            }
            prev = cur;
        }

        out.add(prev);
        return out;
    }

    private boolean intervalsOverlap(Interval i1, Interval i2) {
        return !(i1.end < i2.start || i2.end < i1.start);
    }
}

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class IntervalComparator implements Comparator<Interval> {
    
    @Override
    public int compare(Interval i1, Interval i2) {
        if (i1.start != i2.start) {
            return Integer.compare(i1.start, i2.start);
        } else {
            return Integer.compare(i1.end, i2.end);
        }
    }
}
