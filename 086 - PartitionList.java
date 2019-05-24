/*
https://leetcode.com/problems/partition-list/

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.

Example:
Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
*/

class Solution {
    public ListNode partition(ListNode head, int x) {
        // Maintain 2 lists (prefix and suffix) with their own head and tail
        ListNode pHead = new ListNode(-1);
        ListNode pTail = pHead;
        ListNode sHead = new ListNode(-1);
        ListNode sTail = sHead;

        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                pTail.next = cur;
                pTail = cur;
            } else {
                sTail.next = cur;
                sTail = cur;
            }

            cur = cur.next;
        }

        // Chain prefix and suffix lists
        sTail.next = null;
        pTail.next = sHead.next;
        return pHead.next;
    }
}
