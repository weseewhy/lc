/*
You have N gardens, labelled 1 to N.  In each garden, you want to plant one of 4 types of flowers.
paths[i] = [x, y] describes the existence of a bidirectional path from garden x to garden y.
Also, there is no garden that has more than 3 paths coming into or leaving it.
Your task is to choose a flower type for each garden such that, for any two gardens connected by a path, 
they have different types of flowers.Return any such a choice as an array answer, 
where answer[i] is the type of flower planted in the (i+1)-th garden. 
The flower types are denoted 1, 2, 3, or 4.  It is guaranteed an answer exists.

Example 1:
Input: N = 3, paths = [[1,2],[2,3],[3,1]]
Output: [1,2,3]

Example 2:
Input: N = 4, paths = [[1,2],[3,4]]
Output: [1,2,1,2]

Example 3:
Input: N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
Output: [1,2,3,4]
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            adj.put(i, new HashSet<>());
        }

        for (int[] path : paths) {
            adj.get(path[0]).add(path[1]);
            adj.get(path[1]).add(path[0]);
        }

        int[] out = new int[N];
        for (int i = 1; i <= N; i++) {
            // Holds which flowers are used by neighbors
            int[] used = new int[5];
            for (int neighbor : adj.get(i)) {
                // Check the flower of each neighbor and mark it's flower as used
                used[out[neighbor - 1]] = 1;
            }

            // Find any unused flower and use it
            for (int j = 4; j >= 1; j--) {
                if (used[j] == 0) {
                    out[i - 1] = j;
                    break;
                }
            }
        }

        return out;
    }
}
