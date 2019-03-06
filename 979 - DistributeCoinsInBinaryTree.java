/*
https://leetcode.com/problems/distribute-coins-in-binary-tree/

Given the root of a binary tree with N nodes, each node in the tree has node.val coins, and there are N coins total.
In one move, we may choose two adjacent nodes and move one coin from one node to another.
(The move may be from parent to child, or from child to parent.)

Return the number of moves required to make every node have exactly one coin.

Example 1:
      3
    /  \
   0    0
Input: [3,0,0]
Output: 2
Explanation: From the root of the tree, we move one coin to its left child, and one coin to its right child.

Example 2:
      0
    /  \
   3    0
Input: [0,3,0]
Output: 3
Explanation: From the left child of the root, we move two coins to the root [taking two moves].
Then, we move one coin from the root of the tree to the right child.

Example 3:
      1
    /  \
   0    2
Input: [1,0,2]
Output: 2

Example 4:
      1
    /  \
   0    0
    \
     3
Input: [1,0,0,null,3]
Output: 4
*/

class Solution {
    private int moves;

    public int distributeCoins(TreeNode node) {
        moves = 0;
        dfs(node);
        return moves;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int extraCoinsFromLeft = dfs(node.left);
        int extraCoinsFromRight = dfs(node.right);
        moves += Math.abs(extraCoinsFromLeft) + Math.abs(extraCoinsFromRight);

        // Keep 1 coin and return extra coins to parent
        return node.val + extraCoinsFromLeft + extraCoinsFromRight - 1;
    }
}
