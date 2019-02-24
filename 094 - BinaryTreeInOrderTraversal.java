/*
https://leetcode.com/problems/binary-tree-inorder-traversal/

Given a binary tree, return the inorder traversal of its nodes' values.

Example:
Input: [1,null,2,3]
   1
    \
     2
    /
   3
Output: [1,3,2]
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> inorderTraversal(TreeNode node) {
        List<Integer> out = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            out.add(node.val);
            node = node.right;
        }

        return out;
    }

    public List<Integer> inorderTraversal_Recursive(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        inorderTraversal_Recursive(root, out);
        return out;
    }

    private void inorderTraversal_Recursive(TreeNode node, List<Integer> out) {
        if (node != null) {
            inorderTraversal_Recursive(node.left, out);
            out.add(node.val);
            inorderTraversal_Recursive(node.right, out);
        }
    }
}
