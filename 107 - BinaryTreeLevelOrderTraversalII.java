/*
https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
(ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
*/

import java.util.*;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();
        if (root == null) {
            return out;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curLevelCnt = 1;
        int nextLevelCnt = 0;
        List<Integer> curLevel = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            curLevel.add(cur.val);
            curLevelCnt--;

            if (cur.left != null) {
                queue.offer(cur.left);
                nextLevelCnt++;
            }

            if (cur.right != null) {
                queue.offer(cur.right);
                nextLevelCnt++;
            }

            if (curLevelCnt == 0) {
                out.add(curLevel);
                curLevel = new ArrayList<>();
                curLevelCnt = nextLevelCnt;
                nextLevelCnt = 0;
            }
        }

        Collections.reverse(out);
        return out;
    }
}
