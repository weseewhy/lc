/*
Given a singly linked list, return a random node's value from the linked list.
Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you?
Could you solve this efficiently without using extra space?

Example:
// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly with equal probability.
solution.getRandom();
*/

import java.util.Random;

class Solution {
    private ListNode head;
    private Random random;

    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    public int getRandom() {
        ListNode node = head;
        ListNode randomNode = node;

        // Holds the number of nodes visited so far
        int cnt = 1;

        while (node.next != null) {
            // We will decide whether we want to select this node or not
            node = node.next;
            cnt++;

            // Now we have 'cnt' nodes (including current node)
            // Select a random number in interval [0, cnt)
            // If the number picked == cnt-1 (index of current node), then we use this node as 'randomNode'
            if (random.nextInt(cnt) == cnt - 1) {
                randomNode = node;
            }
        }

        return randomNode.val;
    }
}

/*
Hint: Reservoir Sampling
(https://leetcode.com/problems/linked-list-random-node/discuss/85659)

Problem:
Choose k entries from n numbers. Make sure each number is selected with the probability of k/n

Basic idea:
  - Choose 1, 2, 3, ..., k first and put them into the reservoir.
  - For k+1, pick it with a probability of k/(k+1), and randomly replace a number in the reservoir.
  - For k+i, pick it with a probability of k/(k+i), and randomly replace a number in the reservoir.
  - Repeat until k+i reaches n

Proof:
  - For k+i, the probability that it is selected and will replace a number in the reservoir is k/(k+i)
  - For a number in the reservoir before (let's say X), the probability that it keeps staying in the reservoir is
        P(X was in the reservoir last time) × P(X is not replaced by k+i)
        = P(X was in the reservoir last time) × (1 - P(k+i is selected and replaces X))
        = k/(k+i-1) × （1 - k/(k+i) × 1/k）
        = k/(k+i)
When k+i reaches n, the probability of each number staying in the reservoir is k/n
 */
