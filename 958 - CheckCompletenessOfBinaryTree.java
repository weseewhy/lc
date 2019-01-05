/*
https://leetcode.com/problems/check-completeness-of-a-binary-tree/

Given a binary tree, determine if it is a complete binary tree.
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes
in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example 1:
Input: [1,2,3,4,5,6]
Output: true
Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}),
and all nodes in the last level ({4, 5, 6}) are as far left as possible.

Example 2:
Input: [1,2,3,4,5,null,7]
Output: false
Explanation: The node with value 7 isn't as far left as possible.
*/

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> curLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();
        curLevel.add(root);
        int expectedNodeCount = 1;
        int nodeCount = 1;
        boolean hasNullBefore = false;

        while (!curLevel.isEmpty()) {
            TreeNode node = curLevel.remove();

            if (node.left == null) {
                hasNullBefore = true;
            } else if (hasNullBefore) {
                return false;
            } else {
                nextLevel.add(node.left);
            }

            if (node.right == null) {
                hasNullBefore = true;
            } else if (hasNullBefore) {
                return false;
            } else {
                nextLevel.add(node.right);
            }

            if (curLevel.isEmpty()) {
                if (nextLevel.isEmpty()) {
                    return true;
                } else if (nodeCount != expectedNodeCount) {
                    return false;
                } else {
                    hasNullBefore = false;
                    expectedNodeCount *= 2;
                    nodeCount = nextLevel.size();
                    curLevel = nextLevel;
                    nextLevel = new LinkedList<>();
                }
            }
        }

        return true;
    }
}
