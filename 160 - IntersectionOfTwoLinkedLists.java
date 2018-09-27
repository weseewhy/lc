/*
https://leetcode.com/problems/intersection-of-two-linked-lists/

Write a program to find the node at which the intersection of two singly linked lists begins.
For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.

Notes:
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode p1 = headA;
        int l1 = 0;
        while (p1 != null) {
            l1++;
            p1 = p1.next;
        }

        ListNode p2 = headB;
        int l2 = 0;
        while (p2 != null) {
            l2++;
            p2 = p2.next;
        }

        if (l1 > l2) {
            p1 = headA;
            p2 = headB;
        } else {
            p1 = headB;
            p2 = headA;
        }

        int diff = Math.abs(l1 - l2);
        while (diff > 0) {
            p1 = p1.next;
            diff--;
        }

        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                return p1;
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }

        return null;
    }
}
