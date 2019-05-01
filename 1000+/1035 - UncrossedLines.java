/*
https://leetcode.com/problems/uncrossed-lines/

We write the integers of A and B (in the order they are given) on two separate horizontal lines.
Now, we may draw a straight line connecting two numbers A[i] and B[j] as long as A[i] == B[j], 
and the line we draw does not intersect any other connecting (non-horizontal) line.

Return the maximum number of connecting lines we can draw in this way.

Example 1:
Input: A = [1,4,2], B = [1,2,4]
Output: 2
Explanation: We can draw 2 uncrossed lines as in the diagram.
We cannot draw 3 uncrossed lines, because the line from A[1]=4 to B[2]=4 will intersect the line from A[2]=2 to B[1]=2.

Example 2:
Input: A = [2,5,1,2,5], B = [10,5,2,1,5,2]
Output: 3

Example 3:
Input: A = [1,3,7,1,7,5], B = [1,9,2,5,1]
Output: 2
*/

class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0) {
            return 0;
        }

        int[][] dp = new int[2][A.length + 1];
        int row = 0;

        for (int num : B) {
            row = 1 - row;
            for (int i = 1; i <= A.length; i++) {
                if (A[i - 1] == num) {
                    dp[row][i] = 1 + dp[1 - row][i - 1];
                } else {
                    dp[row][i] = Math.max(dp[row][i - 1], dp[1 - row][i]);
                }
            }
        }

        return dp[row][A.length];
    }
}

/*
Hint: Longest common sub-sequence
L(i,j) --> Length of longest sub-sequence until ith index of A and jth index of B

L(i,j) =  1 + L(i-1, j-1)               if A[i] == B[j]
       =  MAX(L[i][j-1], L[i-1][j]      if A[i] != B[j]
*/
