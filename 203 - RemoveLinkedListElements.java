/*
https://leetcode.com/problems/remove-linked-list-elements/

Remove all elements from a linked list of integers that have value val.

Example:
Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
*/

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head != null) {
            ListNode prev = head;
            ListNode cur = head.next;

            while (cur != null) {
                if (cur.val == val) {
                    prev.next = cur.next;
                } else {
                    prev = cur;
                }

                cur = cur.next;
            }
        }

        return head;
    }
}
