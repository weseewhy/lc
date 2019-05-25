/*
https://leetcode.com/problems/insertion-sort-list/

Sort a linked list using insertion sort

Example 1:
Input: 4->2->1->3
Output: 1->2->3->4

Example 2:
Input: -1->5->3->4->0
Output: -1->0->3->4->5
*/

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode sortedTail = head;
        ListNode cur = sortedTail.next;

        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val > sortedTail.val) {
                sortedTail = cur;
            } else {
                ListNode node = dummy;
                while (node.next.val < cur.val) {
                    node = node.next;
                }
                cur.next = node.next;
                node.next = cur;
                sortedTail.next = next;
            }

            cur = next;
        }

        return dummy.next;
    }
}
