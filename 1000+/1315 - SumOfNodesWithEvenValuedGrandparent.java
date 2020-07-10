/*
https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/

Given a binary tree, return the sum of values of nodes with even-valued grandparent.
(A grandparent of a node is the parent of its parent, if it exists.)
If there are no nodes with an even-valued grandparent, return 0.

Example 1:
                  6
                /   \
              7       8
            /  \     / \
          2     7   1   3
        /      / \       \
       9      1   4       5
Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 18
Explanation: 2+7+1+3(level 3) + 5(level 4) = 18

Constraints:
  . The number of nodes in the tree is between 1 and 10^4.
  . The value of nodes is between 1 and 100.
*/

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        return helper(root, false, false);
    }

    private int helper(TreeNode node, boolean parentEven, boolean grandParentEven) {
        if (node == null) {
            return 0;
        }

        boolean curEven = node.val % 2 == 0;
        return (grandParentEven ? node.val : 0)             // cur node
                + helper(node.left, curEven, parentEven)    // left tree
                + helper(node.right, curEven, parentEven);  // right tree
    }

    // Modifies tree.
    // Alternative is to use custom object in queue with node, parent/grand-parent even status
    public int sumEvenGrandparent_Iterative(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        TreeNode cur;
        while (!q.isEmpty()) {
            cur = q.poll();

            if (cur.left != null) {
                q.add(cur.left);
                if (cur.val < 0) {
                    sum += cur.left.val;
                }
                if (cur.val % 2 == 0) {
                    cur.left.val = -cur.left.val;
                }
            }

            if (cur.right != null) {
                q.add(cur.right);
                if (cur.val < 0) {
                    sum += cur.right.val;
                }
                if (cur.val % 2 == 0) {
                    cur.right.val = -cur.right.val;
                }
            }
        }

        return sum;
    }
}
