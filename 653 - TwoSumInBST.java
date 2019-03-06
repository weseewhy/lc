/*
https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

Given a Binary Search Tree and a target number, return true if there exist 
two elements in the BST such that their sum is equal to the given target.

Example 1:
Input: 
       5
      / \
     3   6
    / \   \
   2   4   7
Target = 9
Output: True

Example 2:
Input: 
       5
      / \
     3   6
    / \   \
   2   4   7
Target = 28
Output: False
*/

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return findTarget(root, k, set);
    }

    private boolean findTarget(TreeNode node, int k, Set<Integer> set) {
        if (node == null) {
            return false;
        }

        int other = k - node.val;
        if (set.contains(other)) {
            return true;
        }

        set.add(node.val);
        return findTarget(node.left, k, set) || findTarget(node.right, k, set);
    }
}
