/*
https://leetcode.com/problems/cousins-in-binary-tree/

In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
Return true if and only if the nodes corresponding to the values x and y are cousins.

Example 1:
        1
      /   \
     2     3
    /
   4
Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Example 2:
       1
     /   \
    2     3
     \     \
      4     5
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true

Example 3:
       1
     /   \
    2     3
     \
      4
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        } else if (x == y) {
            return false;
        }

        List<TreeNode> parents = new ArrayList<>(2);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curLevelCnt = 1;
        int nextLevelCnt = 0;

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            curLevelCnt--;

            if (cur.left != null) {
                queue.offer(cur.left);
                nextLevelCnt++;
                if (cur.left.val == x || cur.left.val == y) {
                    parents.add(cur);
                }
            }

            if (cur.right != null) {
                queue.offer(cur.right);
                nextLevelCnt++;
                if (cur.right.val == x || cur.right.val == y) {
                    parents.add(cur);
                }
            }

            if (parents.size() == 2) {
                return !parents.get(0).equals(parents.get(1));
            }

            if (curLevelCnt == 0) {
                if (parents.size() == 1) {
                    return false;
                }

                curLevelCnt = nextLevelCnt;
                nextLevelCnt = 0;
            }
        }

        return false;
    }
}
