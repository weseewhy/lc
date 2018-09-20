/*
https://leetcode.com/problems/minimum-distance-between-bst-nodes/

Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.

Example :
Input: 
          4
        /   \
      2      6
     / \    
    1   3  

while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
*/

import java.util.ArrayList;
import java.util.List;

public class MinDistBetweenBSTNodes {

    public int minDiffInBST(TreeNode node) {
        List<Integer> orderedList = new ArrayList<>();
        traverseInorder(node, orderedList);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < orderedList.size() - 1; i++) {
            min = Math.min(min, Math.abs(orderedList.get(i) - orderedList.get(i + 1)));
        }

        return min;
    }

    private void traverseInorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        traverseInorder(node.left, list);
        list.add(node.val);
        traverseInorder(node.right, list);
    }
}
