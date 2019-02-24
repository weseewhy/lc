/*
https://leetcode.com/problems/lru-cache/

Design and implement a data structure for Least Recently Used (LRU) cache. 
It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?
*/

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private DLN head;
    private DLN tail;
    private int capacity;
    private int size;
    private Map<Integer, DLN> map;

    LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.size = 0;

        // Use a dummy head and tail nodes. This will eliminate the need to check for nulls
        // So the original nodes lies between these two nodes
        // head -> 1 -> 2 -> 3 -> tail  == List with elements 1,2,3
        // head -> tail == empty list
        this.head = new DLN();
        this.tail = new DLN();

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    private void insertAtHead(DLN node) {
        if (this.size == this.capacity) {
            removeTail();
        }

        node.next = head.next;
        node.prev = head;

        node.next.prev = node;
        head.next = node;

        this.size++;
        this.map.put(node.key, node);
    }

    private void removeTail() {
        if (this.size > 0) {
            DLN tailNode = tail.prev;
            tail.prev = tailNode.prev;
            tailNode.prev.next = tail;

            map.remove(tailNode.key);
            this.size--;

            tailNode.prev = null;
            tailNode.next = null;
        }
    }

    private DLN removeAndGet(int key) {
        DLN node = this.map.get(key);
        if (node != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            node.next = null;
            node.prev = null;

            this.map.remove(key);
            this.size--;
        }

        return node;
    }

    public void put(int key, int val) {
        DLN node = removeAndGet(key);

        if (node == null) {
            node = new DLN(key, val);
        } else {
            node.val = val;
        }

        insertAtHead(node);
    }

    public int get(int key) {
        DLN node = removeAndGet(key);

        if (node != null) {
            insertAtHead(node);
        }

        return node != null ? node.val : -1;
    }
}

class DLN {
    int key;
    int val;
    DLN prev;
    DLN next;

    DLN() {
    }

    DLN(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
