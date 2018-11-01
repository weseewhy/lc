/*
https://leetcode.com/problems/split-linked-list-in-parts/

Given a (singly) linked list with head node root, write a function to split the linked 
list into k consecutive linked list "parts". The length of each part should be as equal as possible: 
no two parts should have a size differing by more than 1. This may lead to some parts being null.
The parts should be in order of occurrence in the input list, and parts occurring earlier 
should always have a size greater than or equal parts occurring later.
Return a List of ListNode's representing the linked list parts that are formed.

Example 1:
Input:
root = [1, 2, 3], k = 5
Output: [[1],[2],[3],[],[]]

Example 2:
Input:
root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
*/

class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] out = new ListNode[k];
        int length = getLengthOfList(root);
        int subLength = length / k;
        int extra = length % k;

        for (int i = 0; i < k; i++) {
            if (root == null) {
                out[i] = null;
            } else {
                int curLen = subLength;
                if (extra > 0) {
                    curLen++;
                    extra--;
                }

                out[i] = root;
                for (int j = 1; j < curLen; j++) {
                    root = root.next;
                }

                ListNode next = root.next;
                root.next = null;
                root = next;
            }
        }

        return out;
    }

    private int getLengthOfList(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }
}
