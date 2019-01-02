/*
https://leetcode.com/problems/univalued-binary-tree/

A binary tree is univalued if every node in the tree has the same value.
Return true if and only if the given tree is univalued.
*/

import java.util.LinkedList;

class Solution {
    public boolean isUniValTree_Recursive(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isUniValTree_Recursive(root, root.val);
    }

    private boolean isUniValTree_Recursive(TreeNode node, int val) {
        return node == null || (node.val == val && isUniValTree_Recursive(node.left, val) && isUniValTree_Recursive(node.right, val));
    }

    public boolean isUniValTree_Iterative(TreeNode root) {
        if (root == null) {
            return true;
        }

        int val = root.val;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            if (cur.val != val) {
                return false;
            }

            if (cur.left != null) {
                queue.add(cur.left);
            }

            if (cur.right != null) {
                queue.add(cur.right);
            }
        }

        return true;
    }
}
