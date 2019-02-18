/*
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

Given a binary tree, return the zigzag level order traversal of its nodes' values.
(ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/

import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();
        if (root == null) {
            return out;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curLevelCnt = 1;
        int nextLevelCnt = 0;
        boolean leftToRight = true;
        List<Integer> level = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            curLevelCnt--;
            level.add(cur.val);

            if (cur.left != null) {
                queue.offer(cur.left);
                nextLevelCnt++;
            }

            if (cur.right != null) {
                queue.offer(cur.right);
                nextLevelCnt++;
            }

            if (curLevelCnt == 0) {
                if (!leftToRight) {
                    Collections.reverse(level);
                }

                out.add(level);
                level = new ArrayList<>();
                curLevelCnt = nextLevelCnt;
                nextLevelCnt = 0;
                leftToRight = !leftToRight;
            }
        }

        return out;
    }
}
