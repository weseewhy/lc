/*
https://leetcode.com/problems/minimum-index-sum-of-two-lists/

Suppose Andy and Doris want to choose a restaurant for dinner, and they both have
a list of favorite restaurants represented by strings.
You need to help them find out their common interest with the least list index sum.
If there is a choice tie between answers, output all of them with no order requirement.
You could assume there always exists an answer.

Example 1:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".

Example 2:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.putIfAbsent(list1[i], i);
        }

        Map<String, Integer> cnt = new HashMap<>();
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                cnt.put(list2[i], i + map.get(list2[i]));
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i : cnt.values()) {
            if (i < min) {
                min = i;
            }
        }

        List<String> out = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            if (entry.getValue() == min) {
                out.add(entry.getKey());
            }
        }

        return out.toArray(new String[]{});
    }
}
