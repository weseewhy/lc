/*
https://leetcode.com/problems/n-ary-tree-preorder-traversal/

Given an n-ary tree, return the preorder traversal of its nodes' values.

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int val,List<Node> children) {
        val = val;
        children = children;
    }
};
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> preOrderRecursive(Node root) {
        List<Integer> out = new ArrayList<>();
        preOrderRecursive(root, out);
        return out;
    }

    private void preOrderRecursive(Node node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            for (Node child : node.children) {
                preOrderRecursive(child, list);
            }
        }
    }

    public List<Integer> preOrderIterative(Node node) {
        List<Integer> out = new ArrayList<>();
        if (node != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(node);

            while (!stack.isEmpty()) {
                Node top = stack.pop();
                out.add(top.val);

                for (int i = top.children.size() - 1; i >= 0; i--) {
                    stack.push(top.children.get(i));
                }
            }
        }

        return out;
    }
}
