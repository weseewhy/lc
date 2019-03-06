/*
https://leetcode.com/problems/add-one-row-to-tree/

Given the root of a binary tree, then value v and depth d, you need to add a row of nodes
with value v at the given depth d. The root node is at depth 1.

The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1,
create two tree nodes with value v as N's left subtree root and right subtree root.
And N's original left subtree should be the left subtree of the new left subtree root,
its original right subtree should be the right subtree of the new right subtree root.
If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v
as the new root of the whole original tree, and the original tree is the new root's left subtree.

Example 1:
Input:
       4
     /   \
    2     6
   / \   /
  3   1 5

v = 1
d = 2

Output:
       4
      / \
     1   1
    /     \
   2       6
  / \     /
 3   1   5   
*/

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curDepth = 1;
        int curLevelCount = 1;
        int nextLevelCount = 0;

        while (curDepth < d - 1) {
            TreeNode cur = queue.poll();
            curLevelCount--;

            if (cur.left != null) {
                queue.offer(cur.left);
                nextLevelCount++;
            }

            if (cur.right != null) {
                queue.offer(cur.right);
                nextLevelCount++;
            }

            if (curLevelCount == 0) {
                curDepth++;
                curLevelCount = nextLevelCount;
                nextLevelCount = 0;
            }
        }

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode left = new TreeNode(v);
            left.left = cur.left;
            TreeNode right = new TreeNode(v);
            right.right = cur.right;
            cur.left = left;
            cur.right = right;
        }

        return root;
    }
}
