/*
https://leetcode.com/problems/reorder-list/

Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:
Given 1->2->3->4, reorder it to 1->4->2->3.

Example 2:
Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
*/

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        if (slow == null || slow.next == null) {
            return;
        }

        ListNode fast = slow.next;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = slow.next;
        ListNode secondHalf = slow.next;
        slow.next = null;

        ListNode n1 = head;
        ListNode n2 = reverse(secondHalf);

        while (n2 != null) {
            ListNode nextN2 = n2.next;
            n2.next = n1.next;
            n1.next = n2;
            n1 = n2.next;
            n2 = nextN2;
        }
    }

    private ListNode reverse(ListNode node) {
        ListNode dummyHead = new ListNode(-1);
        while (node != null) {
            ListNode next = node;
            node = node.next;
            next.next = dummyHead.next;
            dummyHead.next = next;
        }

        return dummyHead.next;
    }
}
