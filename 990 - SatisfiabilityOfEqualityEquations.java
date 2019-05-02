/*
https://leetcode.com/problems/satisfiability-of-equality-equations/

Given an array equations of strings that represent relationships between variables, 
each string equations[i] has length 4 and takes one of two different forms: "a==b" or "a!=b". 
Here, a and b are lowercase letters (not necessarily different) that represent one-letter variable names.

Return true if and only if it is possible to assign integers to variable names so as to satisfy all the given equations.

Example 1:
Input: ["a==b","b!=a"]
Output: false
Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.  
There is no way to assign the variables to satisfy both equations.

Example 2:
Input: ["b==a","a==b"]
Output: true
Explanation: We could assign a = 1 and b = 1 to satisfy both equations.

Example 3:
Input: ["a==b","b==c","a==c"]
Output: true

Example 4:
Input: ["a==b","b!=c","c==a"]
Output: false

Example 5:
Input: ["c==c","b==d","x!=z"]
Output: true
*/

import java.util.*;

class Solution {
    public boolean equationsPossible(String[] equations) {
        List<String> notEquals = new ArrayList<>();
        Map<Character, Node> nodes = new HashMap<>();

        for (String s : equations) {
            char first = s.charAt(0);
            char second = s.charAt(3);

            if (s.charAt(1) == '!') {
                notEquals.add(s);
            } else if (first != second) {
                nodes.putIfAbsent(first, new Node(first));
                nodes.putIfAbsent(second, new Node(second));

                Node fN = nodes.get(first);
                Node sN = nodes.get(second);

                fN.adj.add(sN);
                sN.adj.add(fN);
            }
        }

        for (String ne : notEquals) {
            Node node = nodes.get(ne.charAt(0));
            if (ne.charAt(0) == ne.charAt(3) || node != null && areEqual(node, ne.charAt(3))) {
                return false;
            }
        }

        return true;
    }

    private boolean areEqual(Node node, char other) {
        Set<Character> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        visited.add(node.val);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.val == other) {
                return true;
            }

            for (Node n : cur.adj) {
                if (!visited.contains(n.val)) {
                    queue.offer(n);
                    visited.add(n.val);
                }
            }
        }

        return false;
    }

    // UNION FIND
    // https://leetcode.com/problems/satisfiability-of-equality-equations/discuss/234486
    public boolean equationsPossible_unionFind(String[] equations) {
        List<String> notEquals = new ArrayList<>();
        int[] uf = new int[26];
        for (int i = 0; i < 26; i++) {
            uf[i] = i;
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                notEquals.add(eq);
            } else {
                // Set root of left component equal to root of right component
                uf[findRoot(uf, eq.charAt(0) - 'a')] = findRoot(uf, eq.charAt(3) - 'a');
            }
        }

        for (String ne : notEquals) {
            // Check if they have same root
            if (findRoot(uf, ne.charAt(0) - 'a') == findRoot(uf, ne.charAt(3) - 'a')) {
                return false;
            }
        }

        return true;
    }

    private int findRoot(int[] uf, int x) {
        if (x == uf[x]) {
            // if cur is already root, then return
            return x;
        }

        // otherwise return root of parent
        return findRoot(uf, uf[x]);
    }
}

class Node {
    char val;
    Set<Node> adj;

    Node(char val) {
        this.val = val;
        this.adj = new HashSet<>();
    }
}
