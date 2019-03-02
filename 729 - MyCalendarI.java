/*
https://leetcode.com/problems/my-calendar-i/

Implement a MyCalendar class to store your events.
A new event can be added if adding the event will not cause a double booking.

Your class will have the method, book(int start, int end).
Formally, this represents a booking on the half open interval [start, end),
the range of real numbers x such that start <= x < end.

A double booking happens when two events have some non-empty intersection
(ie., there is some time that is common to both events.)

For each call to the method MyCalendar.book, return true if the event can be
added to the calendar successfully without causing a double booking.
Otherwise, return false and do not add the event to the calendar.

Example 1:

MyCalendar();
MyCalendar.book(10, 20); // returns true
MyCalendar.book(15, 25); // returns false
MyCalendar.book(20, 30); // returns true
Explanation:
The first event can be booked.  The second can't because time 15 is already booked by another event.
The third event can be booked, as the first event takes every time less than 20, but not including 20.
*/

import java.util.Map;
import java.util.TreeMap;

class MyCalendar {
    private TreeMap<Integer, Integer> map;

    public MyCalendar() {
        this.map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if (start > end) {
            return false;
        }

        Map.Entry<Integer, Integer> prev = map.floorEntry(start);
        if (prev != null && start < prev.getValue()) {
            return false;
        }

        Map.Entry<Integer, Integer> next = map.ceilingEntry(start);
        if (next != null && end > next.getKey()) {
            return false;
        }

        map.put(start, end);
        return true;
    }
}
