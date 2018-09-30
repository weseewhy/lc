/*
https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/

In a deck of cards, each card has an integer written on it.
Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck 
into 1 or more groups of cards, where: 
    - Each group has exactly X cards.
    - All the cards in each group have the same integer.
 
Example 1:
Input: [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]

Example 2:
Input: [1,1,1,2,2,2,3,3]
Output: false
Explanation: No possible partition.

Example 3:
Input: [1]
Output: false
Explanation: No possible partition.

Example 4:
Input: [1,1]
Output: true
Explanation: Possible partition [1,1]

Example 5:
Input: [1,1,2,2,2,2]
Output: true
Explanation: Possible partition [1,1],[2,2],[2,2]
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : deck) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }

        int gcd = 0;
        for (int i : countMap.values()) {
            if (i == 1) {
                return false;
            } else {
                gcd = getGCD(gcd, i);
            }
        }

        return gcd > 1;
    }

    private int getGCD(int a, int b) {
        return b == 0 ? a : getGCD(b, a % b);
    }
}
