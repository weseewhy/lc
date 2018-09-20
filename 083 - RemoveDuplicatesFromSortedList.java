/*
https://leetcode.com/problems/remove-duplicates-from-sorted-list/

Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:
Input: 1->1->2
Output: 1->2

Example 2:
Input: 1->1->2->3->3
Output: 1->2->3
*/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode node = head.next;
        ListNode prev = head;
        while (node != null) {
            if (node.val != prev.val) {
                prev.next = node;
                prev = node;
            }

            node = node.next;
        }

        prev.next = null;
        return head;
    }
}
