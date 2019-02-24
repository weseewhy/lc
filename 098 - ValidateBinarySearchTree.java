/*
https://leetcode.com/problems/validate-binary-search-tree/

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:
    - The left subtree of a node contains only nodes with keys less than the node's key.
    - The right subtree of a node contains only nodes with keys greater than the node's key.
    - Both the left and right subtrees must also be binary search trees.

Example 1:
Input:
    2
   / \
  1   3
Output: true

Example 2:
    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.
*/

import java.util.Stack;

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        } else if (min != null && node.val <= min) {
            return false;
        } else if (max != null && node.val >= max) {
            return false;
        }

        return isValidBST(node.left, min, node.val) &&
                isValidBST(node.right, node.val, max);
    }

    // Inorder traversal of BST will be a increasing sequence
    public boolean isValidateBST_iterative(TreeNode node) {
        if (node == null) {
            return true;
        }

        TreeNode prev = null;

        // Store the node into stack and traverse left
        // When nothing to traverse, pop from stack (will be previous root)
        // print it and go right. Repeat
        Stack<TreeNode> stack = new Stack<>();

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();

            if (prev != null && prev.val >= node.val) {
                return false;
            }

            prev = node;
            node = node.right;
        }

        return true;
    }
}
