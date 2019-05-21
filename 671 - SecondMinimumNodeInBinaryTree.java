/*
https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/

Given a non-empty special binary tree consisting of nodes with the non-negative value, 
where each node in this tree has exactly two or zero sub-node. 
If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' 
value in the whole tree. If no such second minimum value exists, output -1 instead.

Example 1:
Input: 
    2
   / \
  2   5
     / \
    5   7
Output: 5

Example 2:
Input: 
    2
   / \
  2   2
Output: -1
*/

class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null || root.right == null) {
            return -1;
        }

        // 2nd min element must have LOST only to min (root.val) either at current level or any of the sub levels
        int left2ndMin = root.left.val == root.val ? findSecondMinimumValue(root.left) : root.left.val;
        int right2ndMin = root.right.val == root.val ? findSecondMinimumValue(root.right) : root.right.val;

        if (left2ndMin == -1) {
            return right2ndMin;
        } else if (right2ndMin == -1) {
            return left2ndMin;
        } else {
            return Math.min(left2ndMin, right2ndMin);
        }
    }
}
