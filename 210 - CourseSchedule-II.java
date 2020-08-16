/*
https://leetcode.com/problems/course-schedule-ii/

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
which is expressed as a pair: [0,1] Given the total number of courses and a list of prerequisite pairs, 
return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. 
If it is impossible to finish all courses, return an empty array.

Example 1:
Input: 2, [[1,0]] 
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .

Example 2:
Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : prerequisites) {
            map.putIfAbsent(edge[0], new HashSet<>());
            map.get(edge[0]).add(edge[1]);
        }

        // Stores output
        List<Integer> path = new ArrayList<>();
        // Keep track of cur path to detect cycle
        Set<Integer> curPath = new HashSet<>();
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visit(i, map, visited, path, curPath)) {
                return new int[]{}; // cycle exists
            }
        }

        return path.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean visit(int target, Map<Integer, Set<Integer>> graph, boolean[] visited, List<Integer> path, Set<Integer> curPath) {
        if (curPath.contains(target)) { // cycle exists
            return false;
        } else if (visited[target]) {   // Already visited
            return true;
        }

        visited[target] = true;
        curPath.add(target);
        if (graph.containsKey(target)) {
            for (int adj : graph.get(target)) {
                if (!visit(adj, graph, visited, path, curPath)) {
                    return false;
                }
            }
        }
        path.add(target);
        curPath.remove(target);
        return true;
    }
}
