/*
https://leetcode.com/problems/minimum-depth-of-binary-tree/

Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
Note: A leaf is a node with no children.

Example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.
*/

import java.util.LinkedList;

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<TreeNode> level = new LinkedList<>();
        level.add(root);
        level.add(null);
        int curDepth = 1;

        while (!level.isEmpty()) {
            TreeNode node = level.poll();
            if (node == null) {
                curDepth++;
                level.add(null);
                continue;
            }

            if (node.left == null && node.right == null) {
                return curDepth;
            }

            if (node.left != null) {
                level.add(node.left);
            }

            if (node.right != null) {
                level.add(node.right);
            }
        }

        return -1;
    }
}
