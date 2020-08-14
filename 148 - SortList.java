/*
https://leetcode.com/problems/sort-list/

Sort a linked list in O(n log n) time using constant space complexity.

Example 1:
Input: 4->2->1->3
Output: 1->2->3->4

Example 2:
Input: -1->5->3->4->0
Output: -1->0->3->4->5
*/
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode[] splits = split(head);
        ListNode sortedLeft = sortList(splits[0]);
        ListNode sortedRight = sortList(splits[1]);
        return merge(sortedLeft, sortedRight);
    }

    public ListNode[] split(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode l2 = slow.next;
        slow.next = null;

        return new ListNode[]{head, l2};
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode resultHead = null;
        ListNode resultTail = null;
        while (l1 != null && l2 != null) {
            ListNode nextMin;
            if (l1.val < l2.val) {
                nextMin = l1;
                l1 = l1.next;
            } else {
                nextMin = l2;
                l2 = l2.next;
            }
            nextMin.next = null;
            if (resultHead == null) {
                resultHead = nextMin;
                resultTail = nextMin;
            } else {
                resultTail.next = nextMin;
                resultTail = nextMin;
            }
        }

        ListNode remaining = l1 != null ? l1 : l2;
        if (remaining != null) {
            if (resultHead == null) {
                resultHead = remaining;
            } else {
                resultTail.next = remaining;
            }
        }

        return resultHead;
    }
}
