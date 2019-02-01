/*
https://leetcode.com/problems/minimum-moves-to-equal-array-elements

Given a non-empty integer array of size n, find the minimum number of moves required 
to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:
Input: [1,2,3]
Output: 3

Explanation:
Only three moves are needed (remember each move increments two elements):
[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
*/

class Solution {
    public int minMoves(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int n = nums.length;

        for (int i : nums) {
            sum += i;
            min = Math.min(min, i);
        }

        return sum - min * n;
    }
}

/*
Explanation:

Let
sum --> sum of all the numbers, before any moves;
minNum --> min number in the list;
n --> length of the list;

After, say m moves, we get all the numbers as x , and we will get the following equation
sum + m * (n - 1) = x * n ---- (1)

and actually,
  x = minNum + m  ----- (2)

because the minimum number will always be minimum until it reaches the final number,
because every move, other numbers (besides the max) will be incremented too;
from above, we can get, the minimum number will be incremented in every move.
So, if the final number is x, it would be minNum + moves;

solving (1) and (2)
  m = sum - minNum * n
*/
