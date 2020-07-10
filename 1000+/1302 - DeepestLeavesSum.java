/*
https://leetcode.com/problems/deepest-leaves-sum/

Given a binary tree, return the sum of values of its deepest leaves.

Example 1:
Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
              1
            /  \
          2     3
        /  \     \
      4     5     6
     /             \
    7               8
Output: 15
*/

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int deepestLeavesSum(TreeNode node) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        TreeNode cur;
        int size;
        while (!queue.isEmpty()) {
            sum = 0;
            size = queue.size();
            for (int i = 1; i <= size; i++) {
                cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                    sum += cur.val;
                } else {
                    if (cur.left != null) {
                        queue.add(cur.left);
                    }
                    if (cur.right != null) {
                        queue.add(cur.right);
                    }
                }
            }
        }

        return sum;
    }
}
