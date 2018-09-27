/*
https://leetcode.com/problems/linked-list-cycle/

Given a linked list, determine if it has a cycle in it.
Follow up:
Can you solve it without using extra space?
*/

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null & slow != fast) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }

        return fast != null;
    }
}
