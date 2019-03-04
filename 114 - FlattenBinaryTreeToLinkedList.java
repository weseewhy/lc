/*
https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:
    1
   / \
  2   5
 / \   \
3   4   6

The flattened tree should look like:
  1
   \
    2
     \
      3
       \
        4
         \
          5
           \
            6
*/

class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flattenUtil(root);
    }

    private TreeNode flattenUtil(TreeNode node) {
        if (node.left == null && node.right == null) {
            return node;
        }

        TreeNode left = node.left;
        TreeNode right = node.right;
        node.left = null;
        node.right = null;
        TreeNode prev = node;

        if (left != null) {
            prev.right = left;
            prev = flattenUtil(left);
        }

        if (right != null) {
            prev.right = right;
            prev = flattenUtil(right);
        }

        return prev;
    }
}
