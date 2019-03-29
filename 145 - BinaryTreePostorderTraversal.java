/*
https://leetcode.com/problems/binary-tree-postorder-traversal/

Given a binary tree, return the post-order traversal of its nodes' values.

Example:
Input: [1,null,2,3]
   1
    \
     2
    /
   3
Output: [3,2,1]

Follow up: Recursive solution is trivial, could you do it iteratively?
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        if (root == null) {
            return out;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode prev = null;

        while (!stack.empty()) {
            TreeNode cur = stack.peek();
            if (cur.left == null && cur.right == null) {
                out.add(cur.val);
                stack.pop();
            } else if (prev != null && cur.left == prev) { // coming up from left
                if (cur.right != null) {
                    // go right
                    stack.push(cur.right);
                } else {
                    out.add(cur.val);
                    stack.pop();
                }
            } else if (prev != null & cur.right == prev) { // coming up from right
                out.add(cur.val);
                stack.pop();
            } else {
                stack.push(cur.left != null ? cur.left : cur.right);
            }

            prev = cur;
        }

        return out;
    }
}
