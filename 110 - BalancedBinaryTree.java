/*
https://leetcode.com/problems/balanced-binary-tree/

Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as:
a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:
    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:
       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
*/

class Solution {
    public boolean isBalanced(TreeNode root) {
        return isBalanced(root, new Height());
    }

    private boolean isBalanced(TreeNode node, Height h) {
        if (node == null) {
            h.val = 0;
            return true;
        }

        Height lh = new Height();
        boolean leftBalanced = isBalanced(node.left, lh);
        if (!leftBalanced) {
            return false;
        }

        Height rh = new Height();
        boolean rightBalanced = isBalanced(node.right, rh);
        if (!rightBalanced) {
            return false;
        }

        h.val = Math.max(lh.val, rh.val) + 1;
        return Math.abs(lh.val - rh.val) <= 1;
    }
}

class Height {
    int val;
}
