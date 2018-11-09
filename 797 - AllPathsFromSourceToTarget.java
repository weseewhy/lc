/*
https://leetcode.com/problems/all-paths-from-source-to-target/

Given a directed, acyclic graph of N nodes.  
Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  
graph[i] is a list of all nodes j for which the edge (i, j) exists.

Example:
Input: [[1,2], [3], [3], []] 
Output: [[0,1,3],[0,2,3]] 
Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> out = new ArrayList<>();
        traverse(0, new ArrayList<>(), graph, out);
        return out;
    }

    private void traverse(int node, List<Integer> curPath, int[][] graph, List<List<Integer>> allPaths) {
        curPath.add(node);
        if (node == graph.length - 1) {
            allPaths.add(new ArrayList<>(curPath));
        } else {
            for (int i : graph[node]) {
                traverse(i, curPath, graph, allPaths);
            }
        }
        curPath.remove(curPath.size() - 1);
    }
}
