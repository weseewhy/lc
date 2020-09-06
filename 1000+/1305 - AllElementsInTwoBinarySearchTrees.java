/*
https://leetcode.com/problems/all-elements-in-two-binary-search-trees/

Given two binary search trees root1 and root2.
Return a list containing all the integers from both trees sorted in ascending order.

Example 1:
Input: root1 = [2,1,4], root2 = [1,0,3]
          2          1
        /  \       /  \
       1    4     0    3
Output: [0,1,1,2,3,4]

Example 2:
Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
Output: [-10,0,0,1,2,5,7,10]

Example 3:
Input: root1 = [], root2 = [5,1,7,0,2]
Output: [0,1,2,5,7]

Example 4:
Input: root1 = [0,-10,10], root2 = []
Output: [-10,0,10]

Example 5:
Input: root1 = [1,null,8], root2 = [8,1]
          1           8
           \         /
            8       1
Output: [1,1,8,8]

Constraints:
    . Each tree has at most 5000 nodes.
    . Each node's value is between [-10^5, 10^5].
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> getAllElements_Iterative(TreeNode node1, TreeNode node2) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        goLeft(node1, stack1);
        goLeft(node2, stack2);

        Stack<TreeNode> stack;
        List<Integer> out = new ArrayList<>();
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                stack = stack2;
            } else if (stack2.isEmpty()) {
                stack = stack1;
            } else {
                stack = stack1.peek().val <= stack2.peek().val ? stack1 : stack2;
            }

            TreeNode node = stack.pop();
            out.add(node.val);
            node = node.right;
            goLeft(node, stack);
        }

        return out;
    }

    private void goLeft(TreeNode node, Stack<TreeNode> stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    /*############################################################*/

    public List<Integer> getAllElements_Recursive(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        traverse(root1, list1);
        traverse(root2, list2);
        return merge(list1, list2);
    }

    private void traverse(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        traverse(node.left, list);
        list.add(node.val);
        traverse(node.right, list);
    }

    private List<Integer> merge(List<Integer> l1, List<Integer> l2) {
        List<Integer> out = new ArrayList<>(l1.size() + l2.size());
        int l1Index = 0, l2Index = 0;
        while (l1Index < l1.size() && l2Index < l2.size()) {
            if (l1.get(l1Index) <= l2.get(l2Index)) {
                out.add(l1.get(l1Index++));
            } else {
                out.add(l2.get(l2Index++));
            }
        }

        while (l1Index < l1.size()) {
            out.add(l1.get(l1Index++));
        }

        while ((l2Index < l2.size())) {
            out.add(l2.get(l2Index++));
        }

        return out;
    }
}
