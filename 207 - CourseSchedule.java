/*
https://leetcode.com/problems/course-schedule/

There are a total of n courses you have to take, labeled from 0 to n-1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:
Input: 2, [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.

Example 2:
Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses);
        for (int[] arr : prerequisites) {
            graph.addEdge(arr[1], arr[0]);
        }

        return !graph.hasCycle();
    }
}

class Graph {
    private int numberOfVertices;
    private List<List<Integer>> adj;

    Graph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        adj = new ArrayList<>(numberOfVertices);

        for (int i = 0; i < numberOfVertices; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int source, int dest) {
        adj.get(source).add(dest);
    }

    boolean hasCycle() {
        boolean[] visited = new boolean[numberOfVertices];
        Set<Integer> curPath = new HashSet<>();

        for (int i = 0; i < numberOfVertices; i++) {
            if (!visited[i] && hasCycle(i, visited, curPath)) {
                return true;
            }
        }

        return false;
    }

    private boolean hasCycle(int vertex, boolean[] visited, Set<Integer> curPath) {
        if (curPath.contains(vertex)) {
            return true;
        } else if (visited[vertex]) {
            return false;
        }

        visited[vertex] = true;
        curPath.add(vertex);

        for (int neighbor : adj.get(vertex)) {
            if (hasCycle(neighbor, visited, curPath)) {
                return true;
            }
        }

        curPath.remove(vertex);
        return false;
    }
}
