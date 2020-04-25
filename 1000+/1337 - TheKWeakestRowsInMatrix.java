/*
https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/

Given a m * n matrix mat of ones (representing soldiers) and zeros (representing civilians), 
return the indexes of the k weakest rows in the matrix ordered from the weakest to the strongest.

A row i is weaker than row j, if the number of soldiers in row i is less than the number of soldiers in row j, 
or they have the same number of soldiers but i is less than j. Soldiers are always stand in the frontier of a row, 
that is, always ones may appear first and then zeros.

Example 1:
Input: mat = 
[[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]], 
k = 3
Output: [2,0,3]

Example 2:
Input: mat = 
[[1,0,0,0],
 [1,1,1,1],
 [1,0,0,0],
 [1,0,0,0]], 
k = 2
Output: [0,2]
*/

import java.util.PriorityQueue;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        // pq will store [rowNumber, numberOfOnes]
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (r1, r2) -> r1[1] == r2[1] ? r2[0] - r1[0] : r2[1] - r1[1]);
        for (int row = 0; row < mat.length; row++) {
            pq.add(new int[]{row, cntOnes(mat[row])});
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] out = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            out[i] = pq.poll()[0];
        }

        return out;
    }

    // Use binary search for better performance
    private int cntOnes(int[] row) {
        int cnt = 0;
        for (int val : row) {
            if (val == 0) {
                break;
            }
            cnt++;
        }
        return cnt;
    }
}
