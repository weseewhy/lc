/*
https://leetcode.com/problems/top-k-frequent-elements/

Given a non-empty array of integers, return the k most frequent elements.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Note:
  - You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
  - Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/

import java.util.*;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> out = new ArrayList<>();
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            out.add(pq.poll().getKey());
        }

        return out;
    }
}

/*
Time complexity = O(n*lg(k))
If k is close to size of input array, then time complexity with be close to O(n*lg(n))
In that case compute the list of (n-k) less frequent elements and return the remaining elements
 */
