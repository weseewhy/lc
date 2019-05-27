/*
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

Given preorder and inorder traversal of a tree, construct the binary tree.
You may assume that duplicates do not exist in the tree.

Example:
PreOrder = [3,9,20,15,7]
InOrder  = [9,3,15,20,7]
Output: 
    3
   / \
  9  20
    /  \
   15   7
*/

class Solution {
    public TreeNode buildTree(int[] pre, int[] in) {
        return build(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode build(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart == preEnd) {
            return root;
        }

        int leftSize = 0;
        for (int i = inStart; i <= inEnd; i++, leftSize++) {
            if (in[i] == pre[preStart]) {
                break;
            }
        }

        root.left = build(pre, preStart + 1, preStart + leftSize, in, inStart, inStart + leftSize - 1);
        root.right = build(pre, preStart + leftSize + 1, preEnd, in, inStart + leftSize + 1, inEnd);
        return root;
    }
}
