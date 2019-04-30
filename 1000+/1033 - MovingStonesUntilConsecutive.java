/*
https://leetcode.com/problems/moving-stones-until-consecutive/

Three stones are on a number line at positions a, b, and c.
Each turn, let's say the stones are currently at positions x, y, z with x < y < z.
You pick up the stone at either position x or position z, and move that stone to an integer position k, with x < k < z and k != y.
The game ends when you cannot make any more moves, ie. the stones are in consecutive positions.
When the game ends, what is the minimum and maximum number of moves that you could have made?
Return the answer as an length 2 array: answer = [minimum_moves, maximum_moves]

Example 1:
Input: a = 1, b = 2, c = 5
Output: [1, 2]
Explanation: Move stone from 5 to 4 then to 3, or we can move it directly to 3.

Example 2:
Input: a = 4, b = 3, c = 2
Output: [0, 0]
Explanation: We cannot make any moves.

Note:
1 <= a,b,c <= 100
a != b != c
*/

class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int left = Math.min(a, Math.min(b, c));
        int right = Math.max(a, Math.max(b, c));
        int mid = (a != left && a != right) ? a : (b != left && b != right) ? b : c;

        int leftPosCnt = mid - left - 1;
        int rightPosCnt = right - mid - 1;

        int min = (leftPosCnt == 1 || rightPosCnt == 1) ? 1 : (leftPosCnt > 0 ? 1 : 0) + (rightPosCnt > 0 ? 1 : 0);
        int max = leftPosCnt + rightPosCnt;

        return new int[]{min, max};
    }
}
