/*
https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

We are given a binary tree (with root node root), a target node, and an integer value K.
Return a list of the values of all nodes that have a distance K from the target node.

Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2

              3
           /    \
         5       1
        / \     / \
       6   2   0   8
          / \
         7   4

Output: [7,4,1]
*/

import java.util.*;

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parents = constructParentPointers(root);

        List<Integer> out = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);
        int dist = 0;
        int curLevelNodeCnt = 1;
        int nextLevelNodeCnt = 0;

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            curLevelNodeCnt--;
            if (dist == k) {
                out.add(cur.val);
            } else {
                if (cur.left != null && !visited.contains(cur.left)) {
                    queue.offer(cur.left);
                    visited.add(cur.left);
                    nextLevelNodeCnt++;
                }

                if (cur.right != null && !visited.contains(cur.right)) {
                    queue.offer(cur.right);
                    visited.add(cur.right);
                    nextLevelNodeCnt++;
                }

                TreeNode parent = parents.get(cur);
                if (parent != null && !visited.contains(parent)) {
                    queue.offer(parent);
                    visited.add(parent);
                    nextLevelNodeCnt++;
                }

                if (curLevelNodeCnt == 0) {
                    dist++;
                    curLevelNodeCnt = nextLevelNodeCnt;
                    nextLevelNodeCnt = 0;
                }
            }
        }

        return out;
    }

    private Map<TreeNode, TreeNode> constructParentPointers(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        queue.offer(root);
        parentMap.put(root, null);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                parentMap.put(cur.left, cur);
                queue.offer(cur.left);
            }

            if (cur.right != null) {
                parentMap.put(cur.right, cur);
                queue.offer(cur.right);
            }
        }

        return parentMap;
    }
}
