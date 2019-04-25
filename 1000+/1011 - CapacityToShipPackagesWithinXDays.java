/*
https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

A conveyor belt has packages that must be shipped from one port to another within D days.
The i-th package on the conveyor belt has a weight of weights[i].  
Each day, we load the ship with packages on the conveyor belt (in the order given by weights). 
We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages 
on the conveyor belt being shipped within D days.

Example 1:
Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
Output: 15
Explanation: 
A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Example 2:
Input: weights = [3,2,2,4,1,4], D = 3
Output: 6
Explanation: 
A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
1st day: 3, 2
2nd day: 2, 4
3rd day: 1, 4

Example 3:
Input: weights = [1,2,3,1,1], D = 4
Output: 3
Explanation: 
1st day: 1
2nd day: 2
3rd day: 3
4th day: 1, 1
*/

class Solution {
    public int shipWithinDays(int[] weights, int D) {
        // Holds the min capacity of ship that's needed
        // Should be atleast the weight of heaviest package
        int left = 0;

        // Holds the worst case capacity of ship needed
        // Equal to sum of all packages (when needed to ship all of them in single day)
        int right = 0;

        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left < right) {
            // Let's find if there is a better capacity
            int curCapacity = (left + right) / 2;

            // Number of days needed with this current capacity (mid)
            int daysNeeded = 1;
            int packageLoadedSoFar = 0;

            for (int w : weights) {
                // Need a new ship if capacity exceeds after adding current package
                if (packageLoadedSoFar + w > curCapacity) {
                    daysNeeded++;
                    packageLoadedSoFar = 0;
                }

                packageLoadedSoFar += w;
            }

            if (daysNeeded > D) {
                // More days needed ==> increase capacity
                left = curCapacity + 1;
            } else {
                right = curCapacity;
            }
        }

        // We are interested in min possible capacity of ship
        return left;
    }
}
