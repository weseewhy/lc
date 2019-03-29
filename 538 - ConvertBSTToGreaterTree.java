/*
https://leetcode.com/problems/convert-bst-to-greater-tree/

Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST 
is changed to the original key plus sum of all keys greater than the original key in BST.

Example:
Input:
      5
    /   \
   2     13

Output:
      18
     /   \
   20     13
*/

import java.util.Stack;

class Solution {
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int sum = 0;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.right;
            }

            cur = stack.pop();
            cur.val += sum;
            sum = cur.val;
            cur = cur.left;
        }

        return root;
    }
}
