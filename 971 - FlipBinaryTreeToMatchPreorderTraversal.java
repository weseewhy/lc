/*
https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/

Given a binary tree with N nodes, each node has a different value from {1, ..., N}.
A node in this binary tree can be flipped by swapping the left child and the right child of that node.
Consider the sequence of N values reported by a preorder traversal starting from the root.
Call such a sequence of N values the voyage of the tree.

Our goal is to flip the least number of nodes in the tree so that the voyage of the tree matches the voyage we are given.
If we can do so, then return a list of the values of all nodes flipped. You may return the answer in any order.
If we cannot do so, then return the list [-1].

Example 1:
     1
    /
   2
Input: root = [1,2], voyage = [2,1]
Output: [-1]

Example 2:
    1
   / \
  2   3
Input: root = [1,2,3], voyage = [1,3,2]
Output: [1]

Example 3:
    1
   / \
  2   3
Input: root = [1,2,3], voyage = [1,2,3]
Output: []
*/

import java.util.*;

class Solution {
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> out = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < voyage.length; i++) {
            map.put(voyage[i], i);
        }

        boolean canFlipMatch = flipMatchVoyage(root, voyage, 0, voyage.length - 1, map, out);
        return canFlipMatch ? out : Collections.singletonList(-1);
    }

    private boolean flipMatchVoyage(TreeNode node, int[] voyage, int start, int end, Map<Integer, Integer> map, List<Integer> out) {
        if (node == null) {
            return true;
        } else if (node.val != voyage[start]) {
            return false;
        }

        if (node.left == null && node.right == null) {
            return true;
        } else if (node.left == null || node.right == null) {
            return flipMatchVoyage(node.left != null ? node.left : node.right, voyage, start + 1, end, map, out);
        }

        int leftStart = map.get(node.left.val);
        int rightStart = map.get(node.right.val);
        if (leftStart <= start || leftStart > end || rightStart <= start || rightStart > end) {
            return false;
        }

        boolean flipped = leftStart > rightStart;
        if (flipped) {
            out.add(node.val);
        }

        int leftEnd = !flipped ? rightStart - 1 : end;
        int rightEnd = !flipped ? end : leftStart - 1;

        return flipMatchVoyage(node.left, voyage, leftStart, leftEnd, map, out) &&
                flipMatchVoyage(node.right, voyage, rightStart, rightEnd, map, out);
    }
}

/*
If the tree can be modified:
we simulate the flip if needed (based on voyage and recurse)
https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/solution/
*/
