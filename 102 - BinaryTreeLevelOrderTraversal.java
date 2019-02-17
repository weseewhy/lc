/*
https://leetcode.com/problems/binary-tree-level-order-traversal/

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/

import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> out = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curLevelCount = 1;
        int nextLevelCount = 0;
        List<Integer> curLevel = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            curLevel.add(cur.val);
            curLevelCount--;

            if (cur.left != null) {
                queue.offer(cur.left);
                nextLevelCount++;
            }

            if (cur.right != null) {
                queue.offer(cur.right);
                nextLevelCount++;
            }

            if (curLevelCount == 0) {
                out.add(curLevel);
                curLevel = new ArrayList<>();
                curLevelCount = nextLevelCount;
                nextLevelCount = 0;
            }
        }

        return out;
    }
}
