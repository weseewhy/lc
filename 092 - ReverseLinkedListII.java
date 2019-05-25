/*
https://leetcode.com/problems/reverse-linked-list-ii/

Reverse a linked list from position m to n. Do it in one-pass.
Note: 1 ≤ m ≤ n ≤ length of list.

Example:
Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
*/

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prefixTail = dummy;
        for (int i = 0; i < m - 1; i++) {
            prefixTail = prefixTail.next;
        }

        // The first node in the sub-list will become the tail
        ListNode tail = prefixTail.next;
        ListNode cur = prefixTail.next.next;
        
        // For every node in sub-list, insert it as head of sublist
        for (int i = m; i < n; i++) {
            tail.next = cur.next;
            cur.next = prefixTail.next;
            prefixTail.next = cur;
            cur = tail.next;
        }

        return dummy.next;
    }
}
