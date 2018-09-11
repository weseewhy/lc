/*
https://leetcode.com/problems/increasing-order-search-tree

Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.

Example 1:
Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \
1        7   9

Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9
*/

import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderSearchTree {

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        TreeNode newRoot = null;
        TreeNode tail = null;
        for (Integer i : list) {
            TreeNode node = new TreeNode(i);
            if (newRoot == null) {
                newRoot = node;
                tail = node;
            } else {
                tail.right = node;
                tail = node;
            }
        }

        return newRoot;
    }

    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
}
