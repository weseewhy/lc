/*
https://leetcode.com/problems/minimum-cost-for-tickets/

In a country popular for train travel, you have planned some train travelling one year in advance.
The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.

Train tickets are sold in 3 different ways:
    . 1-day pass is sold for costs[0] dollars;
    . 7-day pass is sold for costs[1] dollars;
    . 30-day pass is sold for costs[2] dollars.
The passes allow that many days of consecutive travel.  
For example, if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.

Return the minimum number of dollars you need to travel every day in the given list of days.

Example 1:
Input: days = [1,4,6,7,8,20], costs = [2,7,15]
Output: 11
Explanation: 
For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
In total you spent $11 and covered all the days of your travel.

Example 2:
Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
Output: 17
Explanation: 
For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
In total you spent $17 and covered all the days of your travel.
*/

import java.util.HashSet;
import java.util.Set;

class Solution {
    private int min(int a, int b, int c) {
        int min = Math.min(a, b);
        return Math.min(min, c);
    }
    /*******************************************************/
    /********************** RECURSIVE **********************/
    /*******************************************************/
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> travelDays = new HashSet<>(days.length);
        for (int d : days) {
            travelDays.add(d);
        }

        Integer[] dp = new Integer[366];
        return price(1, dp, travelDays, costs);
    }

    private int price(int day, Integer[] dp, Set<Integer> travelDays, int[] costs) {
        if (day > 365) {
            return 0;
        } else if (dp[day] != null) {
            return dp[day];
        }

        int totalCostFromCurrentDay = 0;
        if (travelDays.contains(day)) {
            totalCostFromCurrentDay = min(
                    costs[0] + price(day + 1, dp, travelDays, costs),
                    costs[1] + price(day + 7, dp, travelDays, costs),
                    costs[2] + price(day + 30, dp, travelDays, costs)
            );
        } else {
            totalCostFromCurrentDay = price(day + 1, dp, travelDays, costs);
        }

        dp[day] = totalCostFromCurrentDay;
        return totalCostFromCurrentDay;
    }

    /*******************************************************/
    /********************** ITERATIVE **********************/
    /*******************************************************/
    public int mincostTickets_V2(int[] days, int[] costs) {
        Set<Integer> travelDays = new HashSet<>(days.length);
        for (int d : days) {
            travelDays.add(d);
        }

        int[] dp = new int[366];
        dp[365] = !travelDays.contains(365) ? 0 : min(costs[0], costs[1], costs[2]);

        for (int i = 364; i >= 1; i--) {
            if (!travelDays.contains(i)) {
                dp[i] = dp[i + 1];
            } else {
                int price = costs[0] + dp[i + 1];

                if (i + 7 <= 365) {
                    price = Math.min(price, costs[1] + dp[i + 7]);
                }

                if (i + 30 <= 365) {
                    price = Math.min(price, costs[2] + dp[i + 30]);
                }

                dp[i] = price;
            }
        }

        return dp[1];
    }
}

/*
We have 3 options for ith day
1) Buy 1 day pass: total price = 1 day price + total price form tomorrow
2) Buy 7 day pass: total price = 7 day price + total price from 7th day from today
3) Buy 30 day pass: .....

dp[i] --> Total price from ith day to end
dp[i] = Min(
             1_day_price + dp[i+1],
             7_day_price + dp[i+7],
             30_day_price + dp[i+30]
           )
*/
