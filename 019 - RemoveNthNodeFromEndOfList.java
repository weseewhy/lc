/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/

Given a linked list, remove the n-th node from the end of list and return its head.

Example:
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.
*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Don't have to worry about null when removing head
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode front = dummyHead;
        for (int i = 0; i <= n; i++) {
            if (front == null) {
                throw new RuntimeException("Length < n");
            }

            front = front.next;
        }

        ListNode back = dummyHead;
        while (front != null) {
            front = front.next;
            back = back.next;
        }

        back.next = back.next.next;
        return dummyHead.next;
    }
}
