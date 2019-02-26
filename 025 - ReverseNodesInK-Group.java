/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
k is a positive integer and is less than or equal to the length of the linked list. 
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5
*/

class Solution {
    public ListNode reverse(ListNode node, int k) {
        ListNode cur = node;
        for (int i = 1; i <= k; i++) {
            if (cur == null) {
                // Lest than k nodes. return original list
                return node;
            }

            cur = cur.next;
        }

        ListNode remainingChain = cur;

        cur = node;
        ListNode prev = null;
        ListNode next;

        for (int i = 1; i <= k; i++) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        node.next = reverse(remainingChain, k);
        return prev;
    }
}
