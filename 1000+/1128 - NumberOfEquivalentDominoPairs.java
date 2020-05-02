/*
https://leetcode.com/problems/number-of-equivalent-domino-pairs/

Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] 
if and only if either (a==c and b==d), or (a==d and b==c) 
that is, one domino can be rotated to be equal to another domino.

Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, 
and dominoes[i] is equivalent to dominoes[j].

Example 1:
Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
Output: 1
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int[] domino : dominoes) {
            Integer score = getScore(domino);
            int existing = map.getOrDefault(score, 0);
            cnt += existing;
            map.put(score, existing + 1);
        }

        return cnt;
    }

    /*
    Possible ways to score a domino
    1) Mark corresponding bits
    2) score = (min * 10) + max;
    */
    private int getScore(int[] domino) {
        return (1 << domino[0]) | (1 << domino[1]);
    }
}
