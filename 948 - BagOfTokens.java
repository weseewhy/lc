/*
https://leetcode.com/problems/bag-of-tokens/

You have an initial power P, an initial score of 0 points, and a bag of tokens.
Each token can be used at most once, has a value token[i], and has potentially two ways to use it.
If we have at least token[i] power, we may play the token face up, losing token[i] power, and gaining 1 point.
If we have at least 1 point, we may play the token face down, gaining token[i] power, and losing 1 point.
Return the largest number of points we can have after playing any number of tokens.

Example 1:
Input: tokens = [100], P = 50
Output: 0

Example 2:
Input: tokens = [100,200], P = 150
Output: 1

Example 3:
Input: tokens = [100,200,300,400], P = 200
Output: 2
*/

import java.util.Arrays;

class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int score = 0;
        int maxScore = 0;

        // When power needed, convert largest tokens first. They use same points(1) but give more power
        int start = 0;
        int end = tokens.length - 1;

        while (start <= end) {
            if (P >= tokens[start]) {    // enough power? convert it to points
                P -= tokens[start];
                score++;
                start++;
                if (score > maxScore) {
                    maxScore = score;
                }
            } else if (score > 0) {     // have points? convert to power
                score--;
                P += tokens[end];
                end--;
            } else {                    // neither enough power nor points? nothing to do
                break;
            }
        }

        return maxScore;
    }
}
