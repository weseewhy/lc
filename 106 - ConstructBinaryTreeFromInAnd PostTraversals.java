/*
https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

Given inorder and postorder traversal of a tree, construct the binary tree.
You may assume that duplicates do not exist in the tree.

Example:
InOrder   = [9,3,15,20,7]
PostOrder = [9,15,7,20,3]
Output:
    3
   / \
  9  20
    /  \
   15   7
*/

class Solution {
    public TreeNode buildTree(int[] in, int[] post) {
        return build(in, 0, in.length - 1, post, 0, post.length - 1);
    }

    private TreeNode build(int[] in, int inStart, int inEnd, int[] post, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(post[postEnd]);
        if (inStart == inEnd) {
            return root;
        }

        int leftSize = 0;
        for (int i = inStart; i <= inEnd; i++, leftSize++) {
            if (in[i] == root.val) {
                break;
            }
        }

        root.left = build(in, inStart, inStart + leftSize - 1, post, postStart, postStart + leftSize - 1);
        root.right = build(in, inStart + leftSize + 1, inEnd, post, postStart + leftSize, postEnd - 1);
        return root;
    }
}
