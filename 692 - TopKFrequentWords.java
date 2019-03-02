/*
https://leetcode.com/problems/top-k-frequent-words/

Given a non-empty list of words, return the k most frequent elements.
Your answer should be sorted by frequency from highest to lowest.
If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.

Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
*/

import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(k, (e1, e2) -> {
            if (!e1.getValue().equals(e2.getValue())) {
                return Integer.compare(e1.getValue(), e2.getValue());
            } else {
                return e2.getKey().compareTo(e1.getKey());
            }
        });

        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> out = new ArrayList<>(k);
        while (!pq.isEmpty()) {
            out.add(pq.poll().getKey());
        }
        
        Collections.reverse(out);
        return out;
    }
}

/*
O(n log k) time and O(n) space.
*/
