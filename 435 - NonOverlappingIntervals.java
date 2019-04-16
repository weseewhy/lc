/*
https://leetcode.com/problems/non-overlapping-intervals/

Given a collection of intervals, find the minimum number of intervals 
you need to remove to make the rest of the intervals non-overlapping.

Note: 
Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.

Example 1:
Input: [ [1,2], [2,3], [3,4], [1,3] ]
Output: 1
Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.

Example 2:
Input: [ [1,2], [1,2], [1,2] ]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.

Example 3:
Input: [ [1,2], [2,3] ]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }

        List<Interval> intervalList = new ArrayList<>();
        for (int[] interval : intervals) {
            intervalList.add(new Interval(interval[0], interval[1]));
        }

        intervalList.sort((i1, i2) -> i1.end != i2.end ?
                Integer.compare(i1.end, i2.end) : Integer.compare(i1.start, i2.start));

        int cnt = 1;
        Interval prev = intervalList.get(0);

        for (int i = 1; i < intervalList.size(); i++) {
            Interval cur = intervalList.get(i);
            if (cur.start >= prev.end) {
                cnt++;
                prev = cur;
            }
        }

        return intervals.length - cnt;
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
