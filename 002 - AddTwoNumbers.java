/*
https://leetcode.com/problems/add-two-numbers/

You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode head = null;
        ListNode tail = null;
        int sum, carry = 0;

        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;

            if (head == null) {
                head = tail = new ListNode(sum);
            } else {
                tail.next = new ListNode(sum);
                tail = tail.next;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode rem = l1 != null ? l1 : l2;
        while (rem != null) {
            sum = rem.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            tail.next = new ListNode(sum);
            tail = tail.next;
            rem = rem.next;
        }

        if (carry != 0) {
            tail.next = new ListNode(carry);
        }

        return head;
    }
}
