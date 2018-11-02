/*
https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

Given a sorted linked list, delete all nodes that have duplicate numbers, 
leaving only distinct numbers from the original list.

Example 1:
Input: 1->2->3->3->4->4->5
Output: 1->2->5

Example 2:
Input: 1->1->1->2->3
Output: 2->3
*/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = null;
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            if (cur.next == null || cur.val != cur.next.val) {
                if (newHead == null) {
                    newHead = cur;
                    prev = cur;
                } else {
                    prev.next = cur;
                    prev = cur;
                }
                cur = cur.next;
            } else {
                int val = cur.val;
                while (cur != null && cur.val == val) {
                    cur = cur.next;
                }
            }
        }

        if (prev != null) {
            prev.next = null;
        }

        return newHead;
    }
}
