/*
https://leetcode.com/problems/minimum-increment-to-make-array-unique/

Given an array of integers A, a move consists of choosing any A[i], and incrementing it by 1.
Return the least number of moves to make every value in A unique.

Example 1:
Input: [1,2,2]
Output: 1
Explanation:  After 1 move, the array could be [1, 2, 3].

Example 2:
Input: [3,2,1,2,1,7]
Output: 6
Explanation:  After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
*/

import java.util.*;

class Solution {
    public int minIncrementForUnique(int[] A) {
        if (A.length <= 1) {
            return 0;
        }

        Set<Integer> distinct = new HashSet<>();
        List<Integer> duplicates = new ArrayList<>();

        for (int i : A) {
            if (distinct.contains(i)) {
                duplicates.add(i);
            } else {
                distinct.add(i);
            }
        }

        int movesRequired = 0;
        int lastDistinct = Integer.MIN_VALUE;
        if (duplicates.size() > 0) {
            Collections.sort(duplicates);

            for (int num : duplicates) {
                int nextDistinct = Math.max(num, lastDistinct) + 1;
                while (distinct.contains(nextDistinct)) {
                    nextDistinct++;
                }
                distinct.add(nextDistinct);
                lastDistinct = nextDistinct;
                movesRequired += nextDistinct - num;
            }
        }

        return movesRequired;
    }
}
