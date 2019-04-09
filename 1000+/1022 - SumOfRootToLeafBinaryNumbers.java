/*
https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/

Given a binary tree, each node has value 0 or 1.
Each root-to-leaf path represents a binary number starting with the most significant bit.
For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.

For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
Return the sum of these numbers.

Example 1:
Input:
            1
          /   \
         0     1
        / \   / \
       0   1 0   1
Output: 22
Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
*/

class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return sumRootToLeaf(root, 0);
    }

    private int sumRootToLeaf(TreeNode node, int carry) {
        carry = (carry * 2) + node.val;
        if (node.left == null && node.right == null) {
            return carry;
        }

        int sum = 0;
        if (node.left != null) {
            sum += sumRootToLeaf(node.left, carry);
        }
        if (node.right != null) {
            sum += sumRootToLeaf(node.right, carry);
        }

        return sum;
    }
}
