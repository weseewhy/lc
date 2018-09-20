/*
Given a non-empty, singly linked list with head node head, return a middle node of linked list.
If there are two middle nodes, return the second middle node.

Input: [1,2,3,4,5]
Output: Node 3

Input: [1,2,3,4,5,6]
Output: Node 4 from this list
*/

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode first = head;
        ListNode second = head.next;
        if (second == null) {
            return first;
        }

        while (true) {
            if (second.next == null || second.next.next == null) {
                return first.next;
            }

            first = first.next;
            second = second.next.next;
        }
    }
}