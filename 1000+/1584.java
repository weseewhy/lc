/*
https://leetcode.com/problems/min-cost-to-connect-all-points/

You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: 
|xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.

Return the minimum cost to make all points connected. All points are connected if there is exactly 
one simple path between any two points.

Example 1:
Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
Output: 20

Example 2:
Input: points = [[3,12],[-2,5],[-4,1]]
Output: 18

Example 3:
Input: points = [[0,0],[1,1],[1,0],[-1,1]]
Output: 4

Example 4:
Input: points = [[-1000000,-1000000],[1000000,1000000]]
Output: 4000000

Example 5:
Input: points = [[0,0]]
Output: 0

Constraints:
    . 1 <= points.length <= 1000
    . -106 <= xi, yi <= 106
    . All pairs (xi, yi) are distinct.
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {

    /*-----------Prim's Minimum Spanning Tree-----------*/

    public int minCostConnectPoints_1(int[][] points) {
        // Adjacency matrix - holds weight of for all edges
        int[][] adj = new int[points.length][points.length];
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int weight = calculateWeight(points[i], points[j]);
                adj[i][j] = weight;
                adj[j][i] = weight;
            }
        }

        // Holds the vertices that are already added to MST
        Set<Integer> mst = new HashSet<>();
        int totalCost = 0;

        // Holds the cost to add the vertex to existing MST
        // To start, let's assume that vertex 0 is in MST.
        // So it's cost is 0. Cost for all remaining vertices is Infinite
        int[] costs = new int[points.length];
        for (int i = 1; i < costs.length; i++) {
            costs[i] = Integer.MAX_VALUE;
        }

        while (mst.size() < points.length) {
            int nextVertex = -1;
            int minCost = Integer.MAX_VALUE;
            // Pick the vertex with min cost that is not already part of MST
            for (int i = 0; i < points.length; i++) {
                if (!mst.contains(i) && costs[i] < minCost) {
                    minCost = costs[i];
                    nextVertex = i;
                }
            }

            // Add this vertex to MST
            mst.add(nextVertex);
            totalCost += minCost;

            // Now for all the adjoining vertices of this vertex, update the cost if it's cheaper
            for (int i = 0; i < points.length; i++) {
                if (i != nextVertex && !mst.contains(i)) {
                    costs[i] = Math.min(costs[i], adj[nextVertex][i]);
                }
            }
        }

        return totalCost;
    }


    /*-----------Kruskal's Minimum Spanning Tree-----------*/

    // Union-find
    public int minCostConnectPoints_2(int[][] points) {
        // Sort all edges by their weight
        PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                edges.add(new Edge(i, j, calculateWeight(points[i], points[j])));
            }
        }

        // Holds the parent to each element.
        // At start, every element has it's parent set to self
        int[] parents = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            parents[i] = i;
        }

        int totalCost = 0;
        int edgesNeeded = points.length - 1;
        while (edgesNeeded > 0 && !edges.isEmpty()) {
            Edge edge = edges.poll();
            int v1Parent = findRoot(parents, edge.v1);
            int v2Parent = findRoot(parents, edge.v2);

            // If 2 vertices have same parent, then they are already in same group
            // Connecting them will create a cycle. So, ignore such vertices
            // Otherwise merge them (set parent of 2nd root to first)
            if (v1Parent != v2Parent) {
                parents[v2Parent] = v1Parent;
                edgesNeeded--;
                totalCost += edge.weight;
            }
        }

        return totalCost;
    }

    // Find the top-most parent (root)
    private int findRoot(int[] parents, int i) {
        while (i != parents[i]) {
            i = parents[i];
        }
        return parents[i];
    }

    /***************************************************/

    public int minCostConnectPoints_3(int[][] points) {
        // Sort all edges by their weight
        PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                edges.add(new Edge(i, j, calculateWeight(points[i], points[j])));
            }
        }
        int edgesAdded = 0;
        int maxEdges = points.length - 1;
        int totalCost = 0;
        int nextGroupId = 1;

        // Maintain connected components
        // Key   --> id (random)
        // Value --> Set of all vertices in this component
        Map<Integer, Set<Integer>> connected = new HashMap<>();

        while (!edges.isEmpty() && edgesAdded < maxEdges) {
            Edge edge = edges.poll();
            int v1Group = getGroup(connected, edge.v1);
            int v2Group = getGroup(connected, edge.v2);

            if (v1Group == -1 && v2Group == -1) {
                // Neither of the vertices are in any group. Create a new group for them
                connected.put(nextGroupId++, new HashSet<>(Arrays.asList(edge.v1, edge.v2)));
            } else if (v1Group == v2Group) {
                // Both the vertices are already in same group. No need to connect them
                continue;
            } else if (v1Group == -1) {
                // v1 doesn't belong to any group. Add it to same group as v2
                connected.get(v2Group).add(edge.v1);
            } else if (v2Group == -1) {
                // v2 doesn't belong to any group. Add it to same group as v1
                connected.get(v1Group).add(edge.v2);
            } else {
                // Both vertices belong to different groups. Merge those two groups
                // Add all elements from group2 into group1 and delete group2
                connected.get(v1Group).addAll(connected.get(v2Group));
                connected.remove(v2Group);
            }

            totalCost += edge.weight;
            edgesAdded++;
        }

        return totalCost;
    }

    private int getGroup(Map<Integer, Set<Integer>> groups, int v) {
        for (int id : groups.keySet()) {
            if (groups.get(id).contains(v)) {
                return id;
            }
        }
        return -1;
    }


    private int calculateWeight(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}

class Edge {
    int v1;
    int v2;
    int weight;

    Edge(int v1, int v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }
}
