/*
https://leetcode.com/problems/binary-tree-pruning/

We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.
Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
(Recall that the subtree of a node X is X, plus every node that is a descendant of X.)

          0                                   0
       /      \                             /   \
     1         0            --->          1      0         
   /   \     /   \                                 \
 0      0   0      1                                1
*/

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        boolean has1s = has1s(root);
        return has1s ? root : null;
    }

    private boolean has1s(TreeNode node) {
        if (node == null) {
            return false;
        }

        boolean leftHas1s = has1s(node.left);
        if (!leftHas1s) {
            node.left = null;
        }

        boolean rightHas1s = has1s(node.right);
        if (!rightHas1s) {
            node.right = null;
        }

        return node.val == 1 || leftHas1s || rightHas1s;
    }
}
