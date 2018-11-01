/*
https://leetcode.com/problems/swap-nodes-in-pairs/

Given a linked list, swap every two adjacent nodes and return its head.

Example:
Given 1->2->3->4, you should return the list as 2->1->4->3.

Note:
Your algorithm should use only constant extra space.
You may not modify the values in the list's nodes, only nodes itself may be changed.
*/

class Solution {
    public ListNode swapPairs_Recursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = swapPairs_Recursive(head.next.next);
        ListNode newHead = head.next;
        newHead.next = head;
        newHead.next.next = next;
        return newHead;
    }

    public ListNode swapPairs_Iterative(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        ListNode first = head;
        ListNode second = head.next;
        ListNode prev = null;

        while (first != null & second != null) {
            ListNode next = second.next;
            second.next = first;
            first.next = second;

            if (prev != null) {
                prev.next = second;
            }
            prev = first;

            first = next;
            second = next != null ? next.next : null;
        }

        prev.next = first;
        return newHead;
    }
}
