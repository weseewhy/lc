/*
https://leetcode.com/problems/binary-tree-right-side-view/

Given a binary tree, imagine yourself standing on the right side of it, 
return the values of the nodes you can see ordered from top to bottom.

Example:
Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        if (root == null) {
            return out;
        }

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
            }

            if (cur.right != null) {
                queue.offer(cur.right);
                nextLevelCnt++;
            }

            if (curLevelCnt == 0) {
                out.add(cur.val);
                curLevelCnt = nextLevelCnt;
                nextLevelCnt = 0;
            }
        }

        return out;
    }
}
