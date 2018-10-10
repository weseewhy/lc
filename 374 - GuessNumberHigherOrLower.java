/*
https://leetcode.com/problems/guess-number-higher-or-lower/

We are playing the Guess Game. The game is as follows:
I pick a number from 1 to n. You have to guess which number I picked.
Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
 
Example :
Input: n = 10, pick = 6
Output: 6
*/

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int min = 1;
        int max = n;

        while (min <= max) {
            int curGuess = min + (max - min) / 2;
            int res = guess(curGuess);
            if (res == 0) {
                return curGuess;
            } else if (res == -1) {
                max = curGuess - 1;
            } else {
                min = curGuess + 1;
            }
        }

        return -1;
    }
}
