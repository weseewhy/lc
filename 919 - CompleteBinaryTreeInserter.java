/*
https://leetcode.com/problems/complete-binary-tree-inserter/

A complete binary tree is a binary tree in which every level, except possibly the last,
is completely filled, and all nodes are as far left as possible.

Write a data structure CBTInserter that is initialized with a complete binary tree
and supports the following operations:
   - CBTInserter(TreeNode root) initializes the data structure on a given tree with head node root;
   - CBTInserter.insert(int v) will insert a TreeNode into the tree with value node.val = v
     so that the tree remains complete, and returns the value of the parent of the inserted TreeNode;
   - CBTInserter.get_root() will return the head node of the tree.

Example 1:
Input: inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
Output: [null,1,[1,2]]

Example 2:
Input: inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
Output: [null,3,4,[1,2,3,4,5,6,7,8]]
*/

import java.util.LinkedList;
import java.util.Queue;

class CBTInserter {

    private TreeNode root;
    private Queue<TreeNode> queue;

    public CBTInserter(TreeNode root) {
        this.root = root;
        this.queue = new LinkedList<>();
        this.queue.offer(root);

        TreeNode cur;
        while (true) {
            cur = queue.peek();
            if (cur.left != null) {
                queue.offer(cur.left);
            }

            if (cur.right != null) {
                queue.offer(cur.right);
            }

            if (cur.left == null || cur.right == null) {
                break;
            } else {
                queue.poll();
            }
        }
    }

    public int insert(int v) {
        TreeNode node = queue.peek();
        TreeNode newNode = new TreeNode(v);

        if (node.left == null) {
            node.left = newNode;
        } else {
            node.right = newNode;
            queue.poll();
        }

        queue.add(newNode);
        return node.val;
    }

    public TreeNode get_root() {
        return this.root;
    }
}
