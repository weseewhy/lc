/*
https://leetcode.com/problems/merge-two-sorted-lists/

Merge two sorted linked lists and return it as a new list.
The new list should be made by splicing together the nodes of the first two lists.

Example:
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

*/
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode out = new ListNode(-1);
        ListNode tail = out;
        while (l1 != null && l2 != null) {
            ListNode node;
            if (l1.val <= l2.val) {
                node = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                node = new ListNode(l2.val);
                l2 = l2.next;
            }

            tail.next = node;
            tail = node;
        }

        while (l1 != null) {
            ListNode node = new ListNode(l1.val);
            tail.next = node;
            tail = node;
            l1 = l1.next;
        }

        while (l2 != null) {
            ListNode node = new ListNode(l2.val);
            tail.next = node;
            tail = node;
            l2 = l2.next;
        }

        return out.next;
    }
}
