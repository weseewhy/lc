/*
https://leetcode.com/problems/next-greater-node-in-linked-list/

We are given a linked list with head as the first node.  Let's number the nodes in the list: node_1, node_2, node_3, ... etc.
Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val such that j > i, node_j.val > node_i.val, 
and j is the smallest possible choice.  If such a j does not exist, the next larger value is 0. 
Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).

Example 1:
Input: [2,1,5]
Output: [5,5,0]

Example 2:
Input: [2,7,4,3,5]
Output: [7,0,5,5,0]

Example 3:
Input: [1,7,5,1,9,2,5,1]
Output: [7,9,9,9,0,5,0,0]
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int[] out = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < list.size(); i++) {
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
                out[stack.pop()] = list.get(i);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            out[stack.pop()] = 0;
        }

        return out;
    }
}
