/*
https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/

Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.
A node is deepest if it has the largest depth possible among any node in the entire tree.
The subtree of a node is that node, plus the set of all descendants of that node.
Return the node with the largest depth such that it contains all the deepest nodes in its subtree.

Example 1:

Input:
         3
       /   \
      5     1
    /  \   /  \
   6   2  0    8
      / \
     7   4
Output:
        2
      /  \
     7    4
*/

class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    private DeepNode dfs(TreeNode node) {
        if (node == null) {
            return new DeepNode(null, 0);
        }

        DeepNode left = dfs(node.left);
        DeepNode right = dfs(node.right);

        int heightOfCurrentSubTree = Math.max(left.height, right.height) + 1;
        if (left.height == right.height) {
            return new DeepNode(node, heightOfCurrentSubTree);
        } else if (left.height > right.height) {
            return new DeepNode(left.node, heightOfCurrentSubTree);
        } else {
            return new DeepNode(right.node, heightOfCurrentSubTree);
        }
    }
}

class DeepNode {
    TreeNode node;
    int height;

    DeepNode(TreeNode node, int height) {
        this.node = node;
        this.height = height;
    }
}
