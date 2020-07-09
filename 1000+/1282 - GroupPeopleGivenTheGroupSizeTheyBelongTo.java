/*
https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/

There are n people whose IDs go from 0 to n - 1 and each person belongs exactly to one group.
Given the array groupSizes of length n telling the group size each person belongs to,
return the groups there are and the people's IDs each group includes.

You can return any solution in any order and the same applies for IDs. 
Also, it is guaranteed that there exists at least one solution.

Example 1:
Input: groupSizes = [3,3,3,3,3,1,3]
Output: [[5],[0,1,2],[3,4,6]]
Other possible solutions are [[2,1,6],[5],[0,4,3]] and [[5],[0,6,2],[4,3,1]].

Example 2:
Input: groupSizes = [2,1,3,3,3,2]
Output: [[1],[0,5],[2,3,4]]

Constraints:
    . groupSizes.length == n
    . 1 <= n <= 500
    . 1 <= groupSizes[i] <= n
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> out = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            List<Integer> list = map.computeIfAbsent(size, k -> new ArrayList<>());
            list.add(i);
            if (list.size() == size) {
                out.add(list);
                map.remove(size);
            }
        }

        return out;
    }
}
