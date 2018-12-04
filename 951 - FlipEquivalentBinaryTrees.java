/*
https://leetcode.com/problems/flip-equivalent-binary-trees/

For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child subtrees.
A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of flip operations.
Write a function that determines whether two binary trees are flip equivalent. The trees are given by root nodes root1 and root2.
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean flipEquiv_1(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        } else if (root1.val != root2.val) {
            return false;
        } else {
            return (flipEquiv_1(root1.left, root2.left) && flipEquiv_1(root1.right, root2.right)) ||
                    (flipEquiv_1(root1.left, root2.right) && flipEquiv_1(root1.right, root2.left));
        }
    }

    // Works only when all nodes are distinct
    public boolean flipEquiv_2(TreeNode root1, TreeNode root2) {
        List<Integer> root1Vals = new ArrayList<>();
        List<Integer> root2Vals = new ArrayList<>();
        traverse(root1, root1Vals);
        traverse(root2, root2Vals);
        return root1Vals.equals(root2Vals);
    }

    // DFS but always visit smaller node first
    private void traverse(TreeNode node, List<Integer> vals) {
        if (node == null) {
            return;
        }

        vals.add(node.val);
        int left = node.left != null ? node.left.val : -1;
        int right = node.right != null ? node.right.val : -1;

        if (left < right) {
            traverse(node.left, vals);
            traverse(node.right, vals);
        } else {
            traverse(node.right, vals);
            traverse(node.left, vals);
        }
    }
}
