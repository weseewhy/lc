/*
https://leetcode.com/problems/n-ary-tree-level-order-traversal/

Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example, given a 3-ary tree:
            1
          / | \
         3  2  4
        /\
       5  6
We should return its level order traversal:
[
     [1],
     [3,2,4],
     [5,6]
]
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> out = new ArrayList<>();
        if (root == null) {
            return out;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<Integer> levelNums = new ArrayList<>();

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == null) {
                out.add(levelNums);
                if (!queue.isEmpty()) {
                    queue.add(null);
                    levelNums = new ArrayList<>();
                }
                continue;
            }

            levelNums.add(node.val);
            for (Node child : node.children) {
                if (child != null) {
                    queue.add(child);
                }
            }
        }

        return out;
    }
}
