/*
Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:
    2
   / \
  1   3
Output: 1

Example 2:
Input:
        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7
Output: 7

Note: You may assume the tree (i.e., the given root node) is not NULL.
*/

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        NodeDepth result = new NodeDepth();
        dfs(root, 0, result);
        return result.node.val;
    }

    private void dfs(TreeNode node, int depth, NodeDepth result) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            if (result.node == null || depth > result.depth) {
                result.node = node;
                result.depth = depth;
            }
        } else {
            dfs(node.left, depth + 1, result);
            dfs(node.right, depth + 1, result);
        }
    }
}

class NodeDepth {
    TreeNode node;
    int depth;
}

/*
Alternative: 
Do BFS from right to left. Last node visited will be the result
 */
