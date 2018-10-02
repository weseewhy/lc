/*
https://leetcode.com/problems/same-tree/

Given two binary trees, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:
Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true

Example 2:
Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false

Example 3:
Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false
*/

import java.util.LinkedList;

class Solution {
    public boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null || p.val != q.val) {
            return false;
        } else {
            return isSameTreeRecursive(p.left, q.left) && isSameTreeRecursive(p.right, q.right);
        }
    }

    public boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        LinkedList<TreeNode> q1 = new LinkedList<>();
        LinkedList<TreeNode> q2 = new LinkedList<>();
        q1.offer(p);
        q2.offer(q);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode n1 = q1.pop();
            TreeNode n2 = q2.pop();

            if (n1.val != n2.val) {
                return false;
            }

            if (n1.left != null && n2.left != null) {
                q1.offer(n1.left);
                q2.offer(n2.left);
            } else if (onlyOneNull(n1.left, n2.left)) {
                return false;
            }

            if (n1.right != null && n2.right != null) {
                q1.offer(n1.right);
                q2.offer(n2.right);
            } else if (onlyOneNull(n1.right, n2.right)) {
                return false;
            }
        }

        return true;
    }

    private boolean onlyOneNull(TreeNode n1, TreeNode n2) {
        return (n1 == null && n2 != null) ||
                (n1 != null && n2 == null);
    }
}
