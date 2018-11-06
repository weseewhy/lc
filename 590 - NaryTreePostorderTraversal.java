/*
Given an n-ary tree, return the postorder traversal of its nodes' values.
For example, given a 3-ary tree:
               1
            /  |  \
           3   2   4
         / \
        5   6
Return its post-order traversal as: [5,6,3,2,4,1].
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> postOrder_Recursive(Node root) {
        List<Integer> out = new ArrayList<>();
        if (root != null) {
            postOrder(root, out);
        }
        return out;
    }

    private void postOrder(Node node, List<Integer> list) {
        for (Node child : node.children) {
            postOrder(child, list);
        }
        list.add(node.val);
    }
}
