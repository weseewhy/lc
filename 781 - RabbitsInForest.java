/*
https://leetcode.com/problems/rabbits-in-forest/

In a forest, each rabbit has some color. Some subset of rabbits (possibly all of them)
tell you how many other rabbits have the same color as them. Those answers are placed in an array.
Return the minimum number of rabbits that could be in the forest.

Examples:
Input: answers = [1, 1, 2]
Output: 5
Explanation:
The two rabbits that answered "1" could both be the same color, say red.
The rabbit than answered "2" can't be red or the answers would be inconsistent.
Say the rabbit that answered "2" was blue.
Then there should be 2 other blue rabbits in the forest that didn't answer into the array.
The smallest possible number of rabbits in the forest is therefore 5: 3 that answered plus 2 that didn't.

Input: answers = [10, 10, 10]
Output: 11

Input: answers = []
Output: 0

Note:
    . answers will have length at most 1000.
    . Each answers[i] will be an integer in the range [0, 999].
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numRabbits(int[] answers) {
        // key = # of rabbits in that color group
        // if a rabbit says 2 other rabbits are same color,
        // then 3 rabbits are of that color
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : answers) {
            map.put(val + 1, map.getOrDefault(val + 1, 0) + 1);
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            // <3,5> --> group count of 3, as told by 5 rabbits
            // Split them into 2 groups (because ony 3 can exist in that color group)
            while (val > 0) {
                val -= key;
                res += key;
            }
        }

        return res;
    }
}
