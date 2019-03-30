/*
https://leetcode.com/problems/diameter-of-binary-tree/

Given a binary tree, you need to compute the length of the diameter of the tree. 
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
This path may or may not pass through the root.
Note: The length of path between two nodes is represented by the number of edges between them.

Example: 
          1
         / \
        2   3
       / \     
      4   5    
Output: 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
*/

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        NodeInfo info = traverse(root);
        return info.diameter;
    }

    private NodeInfo traverse(TreeNode node) {
        if (node == null || node.left == null && node.right == null) {
            return new NodeInfo(0, 0);
        }

        NodeInfo left = traverse(node.left);
        NodeInfo right = traverse(node.right);

        int height = 1 + Math.max(left.height, right.height);

        int maxChildDiameter = Math.max(left.diameter, right.diameter);
        int diameterWithCurNode = left.height + right.height
                + (node.left != null ? 1 : 0)
                + (node.right != null ? 1 : 0);

        return new NodeInfo(Math.max(maxChildDiameter, diameterWithCurNode), height);
    }
}

class NodeInfo {
    int diameter;
    int height;

    NodeInfo(int diameter, int height) {
        this.diameter = diameter;
        this.height = height;
    }
}
