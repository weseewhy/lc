/*
https://leetcode.com/problems/binary-tree-tilt/

Given a binary tree, return the tilt of the whole tree.
The tilt of a tree node is defined as the absolute difference between the sum of all
left subtree node values and the sum of all right subtree node values. Null node has tilt 0.
The tilt of the whole tree is defined as the sum of all nodes' tilt.

Example:
Input:
         1
       /   \
      2     3
Output: 1
Explanation:
Tilt of node 2 : 0
Tilt of node 3 : 0
Tilt of node 1 : |2-3| = 1
Tilt of binary tree : 0 + 0 + 1 = 1
*/

class Solution {
    public int findTilt(TreeNode root) {
        Tilt tilt = new Tilt();
        sum(root, tilt);
        return tilt.total;
    }

    private int sum(TreeNode node, Tilt tilt) {
        if (node == null) {
            return 0;
        }

        int leftSum = sum(node.left, tilt);
        int rightSum = sum(node.right, tilt);
        tilt.total += Math.abs(leftSum - rightSum);

        return leftSum + rightSum + node.val;
    }

    private class Tilt {
        int total;
    }
}
