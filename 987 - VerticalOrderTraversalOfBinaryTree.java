/*
https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

Given a binary tree, return the vertical order traversal of its nodes values.
For each node at position (X, Y), its left and right children respectively will be at
positions (X-1, Y-1) and (X+1, Y-1). Running a vertical line from X = -infinity to X = +infinity,
whenever the vertical line touches some nodes, we report the values of the nodes in order
from top to bottom (decreasing Y coordinates). If two nodes have the same position,
then the value of the node that is reported first is the value that is smaller.

Return an list of non-empty reports in order of X coordinate. Every report will have a list of values of nodes.

Example 1:
        3
      /  \
     9   20
        /  \
      15    7
Input: [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]

Explanation:
Without loss of generality, we can assume the root node is at position (0, 0):
Then, the node with value 9 occurs at position (-1, -1);
The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
The node with value 20 occurs at position (1, -1);
The node with value 7 occurs at position (2, -2).
*/

import java.util.*;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();
        List<Node> nextLevel = new ArrayList<>();
        queue.offer(new Node(root, 0));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (!map.containsKey(cur.x)) {
                map.put(cur.x, new ArrayList<>());
            }
            map.get(cur.x).add(cur.node.val);

            if (cur.node.left != null) {
                nextLevel.add(new Node(cur.node.left, cur.x - 1));
            }

            if (cur.node.right != null) {
                nextLevel.add(new Node(cur.node.right, cur.x + 1));
            }

            if (queue.isEmpty() && nextLevel.size() > 0) {
                Collections.sort(nextLevel);
                nextLevel.forEach(queue::offer);
                nextLevel.clear();
            }
        }

        return new ArrayList<>(map.values());
    }
}

class Node implements Comparable<Node> {
    TreeNode node;
    int x;

    Node(TreeNode node, int x) {
        this.node = node;
        this.x = x;
    }

    @Override
    public int compareTo(Node other) {
        return this.x != other.x ?
                Integer.compare(this.x, other.x) :
                Integer.compare(this.node.val, other.node.val);
    }
}
