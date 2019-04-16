/*
https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/

Given the root of a binary tree, find the maximum value V for which there exists
different nodes A and B where V = |A.val - B.val| and A is an ancestor of B.

Example:
             8
           /   \
          3    10
        /  \     \
       1    6     14
           / \    /
          4   7  13

Input: [8,3,10,1,6,null,14,null,null,4,7,13]
Output: 7
Explanation:
We have various ancestor-node differences, some of which are given below :
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
*/

class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return maxDiff(root, root.val, root.val);
    }

    private int maxDiff(TreeNode node, int min, int max) {
        if (node == null) {
            return 0;
        }

        int curDiff = Math.max(Math.abs(node.val - min), Math.abs(node.val - max));
        min = Math.min(min, node.val);
        max = Math.max(max, node.val);

        int childDiff = Math.max(maxDiff(node.left, min, max), maxDiff(node.right, min, max));

        return Math.max(curDiff, childDiff);
    }
}
