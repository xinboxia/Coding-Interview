package SystemDesign;

import java.util.HashMap;

/**
    LeetCode 146 : LRU Cache
    https://leetcode.com/problems/lru-cache/
 Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

 Implement the LRUCache class:
 LRUCache(int capacity) Initialize the LRU cache with positive size capacity.

 int get(int key) Return the value of the key if the key exists, otherwise return -1.

 void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache.
 If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 */

//Define a Node class
class Node {
    int key;
    int value;
    Node pre;
    Node next;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {

    HashMap<Integer, Node> map;
    int count, capacity;
    Node head, tail;

    public LRUCache(int capacity) {
        //Initialization(hashmap, dummy node)
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        //Build a Doubly LinkedList
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
        count = 0;
    }

    public int get(int key) {
        if(map.get(key) != null) {
            Node node = map.get(key);
            int result = node.value;
            //Put used node to the head of LinkedList
            //So that tail of the LinkedList is always the least used element
            deleteNode(node);
            addToHead(node);
            return result;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.get(key) != null) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            if(count < capacity) {
                count++;
                addToHead(node);
            } else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
    }

    private void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);

 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 */
