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
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;

            if (fast.next != null) {
                fast = fast.next;
            }
        }

        // Unlink second half
        ListNode secondHalf = slow.next;
        slow.next = null;

        // Reverse second half
        secondHalf = reverse(secondHalf);

        // Now interweave
        ListNode first = head;
        ListNode second = secondHalf;
        while (second != null) {
            ListNode nextSecond = second.next;
            second.next = first.next;
            first.next = second;
            second = nextSecond;
            first = first.next.next;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while (head != null) {
            ListNode cur = head;
            head = head.next;

            cur.next = dummy.next;
            dummy.next = cur;
        }

        return dummy.next;
    }
}
