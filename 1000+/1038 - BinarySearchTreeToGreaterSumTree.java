/*
https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/

Given the root of a binary search tree with distinct values, modify it so that every node has a new value
equal to the sum of the values of the original tree that are greater than or equal to node.val.

Example 1:
Input:
              4
           /    \
         1       6
       /  \     /  \
      0    2   5    7
            \        \
             3        8

Output:
              30
           /     \
         36       21
       /  \      /  \
     36   35    26   15
            \         \
            33         8
*/

class Solution {
    private int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        inorder(root);
        return root;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.right);
        sum += node.val;
        node.val = sum;
        inorder(node.left);
    }
}
