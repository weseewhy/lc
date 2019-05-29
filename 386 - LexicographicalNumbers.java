/*
https://leetcode.com/problems/lexicographical-numbers/

Given an integer n, return 1 - n in lexicographical order.
For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> out = new ArrayList<>(n);
        for (int i = 1; i < 10; i++) {
            dfs(i, n, out);
        }
        return out;
    }

    private void dfs(int cur, int n, List<Integer> out) {
        if (cur > n) return;

        out.add(cur);
        for (int i = 0; i < 10; i++) {
            int child = 10 * cur + i;
            if (child > n) {
                return; // No need to go deep
            }
            dfs(child, n, out);
        }
    }
}

/*
HINT: DFS
https://leetcode.com/problems/lexicographical-numbers/discuss/86231
 */
