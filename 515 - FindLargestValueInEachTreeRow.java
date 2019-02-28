/*
https://leetcode.com/problems/find-largest-value-in-each-tree-row/

You need to find the largest value in each row of a binary tree.

Example:
Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

Output: [1, 3, 9]
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        int curLevelCnt = 0;
        int nextLevelCnt = 0;

        if (root != null) {
            q.offer(root);
            curLevelCnt = 1;
        }

        int levelMax = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            curLevelCnt--;
            levelMax = Math.max(cur.val, levelMax);

            if (cur.left != null) {
                q.offer(cur.left);
                nextLevelCnt++;
            }

            if (cur.right != null) {
                q.offer(cur.right);
                nextLevelCnt++;
            }

            if (curLevelCnt == 0) {
                out.add(levelMax);
                levelMax = Integer.MIN_VALUE;
                curLevelCnt = nextLevelCnt;
                nextLevelCnt = 0;
            }
        }

        return out;
    }
}
