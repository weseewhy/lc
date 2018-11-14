/*
https://leetcode.com/problems/rotate-list/

Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:
Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL

Example 2:
Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
*/

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }

        k = k % len;
        if (k == 0) {
            return head;
        }

        k = len - k;
        ListNode prev = head;
        for (int i = 1; i < k; i++) {
            prev = prev.next;
        }

        ListNode newHead = prev.next;
        prev.next = null;
        tail.next = head;
        return newHead;
    }
}
