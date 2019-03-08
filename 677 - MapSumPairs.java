/*
https://leetcode.com/problems/map-sum-pairs/

Implement a MapSum class with insert, and sum methods.

For the method insert, you'll be given a pair of (string, integer). 
The string represents the key and the integer represents the value. 
If the key already existed, then the original key-value pair will be overridden to the new one.

For the method sum, you'll be given a string representing the prefix, 
and you need to return the sum of all the pairs' value whose key starts with the prefix.

Example 1:
Input: insert("apple", 3), Output: Null
Input: sum("ap"), Output: 3
Input: insert("app", 2), Output: Null
Input: sum("ap"), Output: 5
*/

import java.util.HashMap;
import java.util.Map;

class MapSum {

    private Map<String, Integer> map;
    private Node root;

    public MapSum() {
        this.map = new HashMap<>();
        this.root = new Node();
    }

    public void insert(String key, int val) {
        int diff = val - map.getOrDefault(key, 0);
        map.put(key, val);

        Node cur = root;
        cur.sum += diff;
        for (char c : key.toCharArray()) {
            cur.next.putIfAbsent(c, new Node());
            cur = cur.next.get(c);
            cur.sum += diff;
        }
    }

    public int sum(String prefix) {
        Node cur = root;
        for (char c : prefix.toCharArray()) {
            if (!cur.next.containsKey(c)) {
                return 0;
            }

            cur = cur.next.get(c);
        }

        return cur.sum;
    }
}

class Node {
    int sum = 0;
    Map<Character, Node> next = new HashMap<>();
}
