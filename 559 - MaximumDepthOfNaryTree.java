/*
https://leetcode.com/problems/maximum-depth-of-n-ary-tree/description/

Given a n-ary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
For example, given a 3-ary tree:
               1
            /  |  \
           3   2   4
         / \
        5   6
We should return its max depth, which is 3.
*/

class Solution {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int maxDepth = 0;
        for (Node child : root.children) {
            int depth = maxDepth(child);
            if (depth > maxDepth) {
                maxDepth = depth;
            }
        }

        return maxDepth + 1;
    }
    
    // For iterative approach, do level order traversal
}
