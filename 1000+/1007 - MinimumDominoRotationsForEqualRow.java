/*
https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/

We may rotate the i-th domino, so that A[i] and B[i] swap values.
Return the minimum number of rotations so that all the values in A are the same, 
or all the values in B are the same. If it cannot be done, return -1.

Example 1:
Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
Output: 2
Explanation: If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2 
Example 2:

Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
Output: -1
Explanation: In this case, it is not possible to rotate the dominoes to make one row of values equal.
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    /*
    For each dice value, store all the positions it is in (A/B)
    If any of the dice value all positions (= A.length), then that's the target value to flip. Otherwise, no solution
    Then find which one is better to flip: A -> B or B -> A
    */
    public int minDominoRotations(int[] A, int[] B) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.putIfAbsent(A[i], new HashSet<>());
            map.get(A[i]).add(i);

            map.putIfAbsent(B[i], new HashSet<>());
            map.get(B[i]).add(i);
        }

        int target = -1;
        for (int i = 1; i <= 6; i++) {
            if (map.containsKey(i) && map.get(i).size() == A.length) {
                target = i;
                break;
            }
        }

        if (target == -1) {
            return -1;
        }

        int flipsA = 0;
        int flipsB = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] != target) flipsA++;
            if (B[i] != target) flipsB++;
        }

        return Math.min(flipsA, flipsB);
    }

    /*
    Check if A[0] exists in all positions (Also calculate number of flips needed)
    Otherwise, repeat above process for B[0]
    If neither of them are at all positions, then no solution
    */
    public int minDominoRotations_V2(int[] A, int[] B) {
        int target = A[0];
        int flipsA = 0;
        int flipsB = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] != target && B[i] != target) break;

            if (A[i] != target) flipsA++;
            if (B[i] != target) flipsB++;

            if (i == A.length - 1) return Math.min(flipsA, flipsB);
        }

        target = B[0];
        flipsA = flipsB = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] != target && B[i] != target) break;

            if (A[i] != target) flipsA++;
            if (B[i] != target) flipsB++;

            if (i == A.length - 1) return Math.min(flipsA, flipsB);
        }

        return -1;
    }
}
