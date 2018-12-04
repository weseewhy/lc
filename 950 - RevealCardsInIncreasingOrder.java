/*
https://leetcode.com/problems/reveal-cards-in-increasing-order/

In a deck of cards, every card has a unique integer.  You can order the deck in any order you want.
Initially, all the cards start face down (unrevealed) in one deck.
Now, you do the following steps repeatedly, until all cards are revealed:
    - Take the top card of the deck, reveal it, and take it out of the deck.
    - If there are still cards in the deck, put the next top card of the deck at the bottom of the deck.
    - If there are still unrevealed cards, go back to step 1.  Otherwise, stop.
Return an ordering of the deck that would reveal the cards in increasing order.
The first entry in the answer is considered to be the top of the deck.

Example:
Input: [17,13,11,2,3,5,7]
Output: [2,13,3,11,5,17,7]
Explanation: 
We get the deck in the order [17,13,11,2,3,5,7] (this order doesn't matter), and reorder it.
After reordering, the deck starts as [2,13,3,11,5,17,7], where 2 is the top of the deck.
We reveal 2, and move 13 to the bottom.  The deck is now [3,11,5,17,7,13].
We reveal 3, and move 11 to the bottom.  The deck is now [5,17,7,13,11].
We reveal 5, and move 17 to the bottom.  The deck is now [7,13,11,17].
We reveal 7, and move 13 to the bottom.  The deck is now [11,17,13].
We reveal 11, and move 17 to the bottom.  The deck is now [13,17].
We reveal 13, and move 17 to the bottom.  The deck is now [17].
We reveal 17.
Since all the cards revealed are in increasing order, the answer is correct.
*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        // Idea is to simulate the deck operations on a dummy queue with values 0 to n-1 (n = length of deck)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            queue.add(i);
        }

        int[] out = new int[deck.length];
        Arrays.sort(deck);
        for (int card : deck) {
            int indexForNextSmallest = queue.remove();

            // since deck is sorted, card in the next smallest
            out[indexForNextSmallest] = card;

            // if queue has more, simulate deck operation -- remove first and put it at end of deck
            if (queue.size() > 1) {
                queue.add(queue.remove());
            }
        }

        return out;
    }
}
