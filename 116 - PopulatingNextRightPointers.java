/*
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

You are given a perfect binary tree where all leaves are on the same level,
and every parent has two children. The binary tree has the following definition:
Node {
  int val;
  Node left;
  Node right;
  Node next;
}
Populate each next pointer to point to its next right node.
If there is no next right node, the next pointer should be set to NULL.
*/

class Solution {
    public void connect_Recursive(Node node) {
        if (node == null || node.left == null || node.right == null) {
            return;
        }

        node.left.next = node.right;
        if (node.next != null) {
            node.right.next = node.next.left;
        }

        connect_Recursive(node.left);
        connect_Recursive(node.right);
    }

    public void connect_Iterative(Node root) {
        Node firstNodeInLevel = root;
        
        while (firstNodeInLevel != null) {
            Node node = firstNodeInLevel;
            
            while (node != null) {
                if (node.left != null) {
                    node.left.next = node.right;
                }

                if (node.right != null && node.next != null) {
                    node.right.next = node.next.left;
                }

                node = node.next;
            }

            firstNodeInLevel = firstNodeInLevel.left;
        }
    }
}

class Node {
    int val;
    Node left;
    Node right;
    Node next;

    public Node(int val) {
        this.val = val;
    }
};
