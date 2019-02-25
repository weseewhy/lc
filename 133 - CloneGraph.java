/*
https://leetcode.com/problems/clone-graph/

Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph.
Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.

Example:
   1 ---- 2
   |      |
   |      |
   4 ---- 3
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        return clone(node, new HashMap<>());
    }

    // Do DFS of the graph. Save the reference to cloned node in a map
    private Node clone(Node node, Map<Integer, Node> clonedNodes) {
        if (clonedNodes.containsKey(node.val)) {
            return clonedNodes.get(node.val);
        }

        Node clone = new Node(node.val);
        clonedNodes.put(node.val, clone);

        for (Node adj : node.neighbors) {
            Node clonedAdj = clone(adj, clonedNodes);
            clone.neighbors.add(clonedAdj);
        }

        return clone;
    }
}

class Node {
    int val;
    List<Node> neighbors;

    Node(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }
}
