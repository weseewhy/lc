/*
https://leetcode.com/problems/coin-change/

You are given coins of different denominations and a total amount of money amount. 
Write a function to compute the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1

Note: You may assume that you have an infinite number of each kind of coin.
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    /*********************************************************************/
    /***************************** BOTTOM UP *****************************/
    /*********************************************************************/
    public int coinChange_bottomUp(int[] denominations, int amount) {
        int[] total = new int[amount + 1];
        for (int i = 1; i < total.length; i++) {
            total[i] = -1;
        }

        for (int val : denominations) {
            for (int i = val; i <= amount; i++) {
                if (total[i - val] != -1) {
                    total[i] = total[i] == -1 ? 1 + total[i - val] : Math.min(total[i], 1 + total[i - val]);
                }
            }
        }

        return total[amount];
    }

    /*********************************************************************/
    /****************************** TOP DOWN *****************************/
    /*********************************************************************/
    public int coinChange_topDown(int[] denominations, int amount) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 0);
        return coinChange_topDown(denominations, amount, cache);
    }

    private int coinChange_topDown(int[] denominations, int amount, Map<Integer, Integer> cache) {
        if (cache.containsKey(amount)) {
            return cache.get(amount);
        } else if (amount < 0) {
            return -1;
        }

        int min = -1;
        for (int coin : denominations) {
            int cur = coinChange_topDown(denominations, amount - coin, cache);
            if (cur != -1) {
                min = min == -1 ? cur + 1 : Math.min(cur + 1, min);
            }
        }

        cache.put(amount, min);
        return min;
    }
}
