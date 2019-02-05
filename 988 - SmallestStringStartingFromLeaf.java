/*
https://leetcode.com/problems/smallest-string-starting-from-leaf/

Given the root of a binary tree, each node has a value from 0 to 25 representing the letters 'a' to 'z':
a value of 0 represents 'a', a value of 1 represents 'b', and so on.

Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

(As a reminder, any shorter prefix of a string is lexicographically smaller:
for example, "ab" is lexicographically smaller than "aba".  A leaf of a node is a node that has no children.)

Example 1:
Input: [0,1,2,3,4,3,4]
         a
       /   \
      b     c
    /  \   /  \
   d   e  d    e
Output: "dba"

Example 2:
Input: [25,1,3,1,3,0,2]
         z
       /   \
      b     d
    /  \   /  \
   b   d  a    c
Output: "adz"

Example 3:
Input: [2,2,1,null,1,0,null,0]
          c
       /    \
      c      b
       \    /
        b  a
       /
      a
Output: "abc"
*/

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String smallestFromLeaf(TreeNode root) {
        if (root == null) {
            return "";
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root));
        String smallest = null;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.node.left == null && cur.node.right == null) {
                if (smallest == null || cur.path.compareTo(smallest) < 0) {
                    smallest = cur.path;
                }
            } else {
                if (cur.node.left != null) {
                    q.add(new Node(cur.node.left, cur.path));
                }

                if (cur.node.right != null) {
                    q.add(new Node(cur.node.right, cur.path));
                }
            }
        }

        return smallest;
    }
}

class Node {
    TreeNode node;
    String path;

    Node(TreeNode node) {
        this(node, "");
    }

    Node(TreeNode node, String pathSoFar) {
        this.node = node;
        this.path = (char) ('a' + node.val) + pathSoFar;
    }
}
