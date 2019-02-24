/*
https://leetcode.com/problems/binary-tree-paths/

Given a binary tree, return all root-to-leaf paths.

Example:
Input:
   1
 /   \
2     3
 \
  5
Output: ["1->2->5", "1->3"]
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> out = new ArrayList<>();
        binaryTreePaths(root, new ArrayList<>(), out);
        return out;
    }

    private void binaryTreePaths(TreeNode node, List<Integer> path, List<String> out) {
        if (node == null) {
            return;
        }

        path.add(node.val);
        
        if (node.left == null && node.right == null) {
            out.add(getPath(path));
        } else {
            binaryTreePaths(node.left, path, out);
            binaryTreePaths(node.right, path, out);
        }
        
        path.remove(path.size() - 1);
    }

    private String getPath(List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i));
            if (i != path.size() - 1) {
                sb.append("->");
            }
        }

        return sb.toString();
    }
}
