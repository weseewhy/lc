/*
https://leetcode.com/problems/maximum-width-of-binary-tree/

Given a binary tree, write a function to get the maximum width of the given tree. 
The width of a tree is the maximum width among all levels. 
The binary tree has the same structure as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes
(the leftmost and right most non-null nodes in the level, 
where the null nodes between the end-nodes are also counted into the length calculation.

Example 1:
Input: 
           1
         /   \
        3     2
       / \     \  
      5   3     9 
Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).

Example 2:
Input: 
          1
         /  
        3    
       / \       
      5   3     
Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).

Example 3:
Input: 
          1
         / \
        3   2 
       /        
      5      
Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).

Example 4:
Input: 

          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
*/

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<ANode> queue = new LinkedList<>();
        queue.offer(new ANode(root, 0));
        int maxWidth = 1;
        int curLevelCnt = 1;
        int nextLevelCnt = 0;
        int start = -1;

        while (!queue.isEmpty()) {
            ANode cur = queue.poll();
            curLevelCnt--;
            if (start == -1) {
                start = cur.pos;
            }

            if (cur.node.left != null) {
                queue.offer(new ANode(cur.node.left, cur.pos * 2));
                nextLevelCnt++;
            }

            if (cur.node.right != null) {
                queue.offer(new ANode(cur.node.right, cur.pos * 2 + 1));
                nextLevelCnt++;
            }

            if (curLevelCnt == 0) {
                curLevelCnt = nextLevelCnt;
                nextLevelCnt = 0;
                maxWidth = Math.max(maxWidth, cur.pos - start + 1);
                start = -1;
            }
        }

        return maxWidth;
    }
}

class ANode {
    TreeNode node;
    int pos;

    ANode(TreeNode node, int pos) {
        this.node = node;
        this.pos = pos;
    }
}
