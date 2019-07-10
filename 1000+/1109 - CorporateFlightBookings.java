/*
https://leetcode.com/problems/corporate-flight-bookings/

There are n flights, and they are labeled from 1 to n. We have a list of flight bookings.
The i-th booking bookings[i] = [i, j, k] means that we booked k seats from flights labeled i to j inclusive.
Return an array answer of length n, representing the number of seats booked on each flight in order of their label.

Example 1:
Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
Output: [10,55,45,25,25]
*/

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] out = new int[n];
        for (int[] i : bookings) {
            out[i[0] - 1] += i[2];
            if (i[1] < out.length) {
                out[i[1]] -= i[2];
            }
        }

        for (int i = 1; i < out.length; i++) {
            out[i] += out[i - 1];
        }

        return out;
    }
}

/*
Hint:
Since ranges are continuous, what if we add reservations to the first flight in the range,
and remove them after the last flight in range?
We can then use the running sum to update reservations for all flights.

https://leetcode.com/problems/corporate-flight-bookings/discuss/328871
*/
