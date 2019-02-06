/*
https://leetcode.com/problems/maximize-distance-to-closest-person/

In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty. 
There is at least one empty seat, and at least one person sitting.
Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 
Return that maximum distance to closest person.

Example 1:
Input: [1,0,0,0,1,0,1]
Output: 2
Explanation: 
If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
If Alex sits in any other open seat, the closest person has distance 1.
Thus, the maximum distance to the closest person is 2.

Example 2:
Input: [1,0,0,0]
Output: 3
Explanation: 
If Alex sits in the last seat, the closest person is 3 seats away.
This is the maximum distance possible, so the answer is 3.
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxDistToClosest(int[] seats) {
        Map<Integer, Integer> map = new HashMap<>();
        int last1 = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                last1 = i;
            } else {
                map.put(i, last1 == -1 ? Integer.MAX_VALUE : i - last1);
            }
        }

        last1 = -1;
        int maxDistance = 0;
        for (int i = seats.length - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                last1 = i;
            } else {
                int distanceFromLeft1 = map.get(i);
                int distanceFromRight1 = last1 == -1 ? Integer.MAX_VALUE : last1 - i;
                int curDistance = Math.min(distanceFromLeft1, distanceFromRight1);
                map.put(i, curDistance);
                if (curDistance > maxDistance) {
                    maxDistance = curDistance;
                }
            }
        }

        return maxDistance;
    }
}
