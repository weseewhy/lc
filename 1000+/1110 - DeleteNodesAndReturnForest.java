/*
https://leetcode.com/problems/delete-nodes-and-return-forest/

Given the root of a binary tree, each node in the tree has a distinct value.
After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
Return the roots of the trees in the remaining forest.  You may return the result in any order.

Example:
        1
      /   \
     2      3
   /  \    /  \   
  4    5  6    7
Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> out = new ArrayList<>();
        Set<Integer> delSet = new HashSet<>();
        for (int val : to_delete) {
            delSet.add(val);
        }
        dfs(root, true, out, delSet);
        return out;
    }

    private TreeNode dfs(TreeNode node, boolean isRoot, List<TreeNode> out, Set<Integer> delSet) {
        if (node == null) {
            return null;
        }

        boolean isDeleted = delSet.contains(node.val);
        if (isRoot && !isDeleted) {
            out.add(node);
        }

        node.left = dfs(node.left, isDeleted, out, delSet);
        node.right = dfs(node.right, isDeleted, out, delSet);

        return isDeleted ? null : node;
    }
}
