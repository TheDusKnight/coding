package leetcode._0146_LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    private void addNode(DLinkedNode node) {
        /** 
         * Always add the new node right after head.
        */
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        /** 
         * Remove and existing node from the linked list.
        */
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DLinkedNode node) {
        /** 
         * Move certain node in between to the head.
        */
       removeNode(node); 
       addNode(node);
    }

    private DLinkedNode popTail() {
        /**
         * Pop the current tail.
         */
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
    // class inner fields
    private Map<Integer, DLinkedNode> cache;
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache2(int capacity) {
        this.cache = new HashMap<>();
        this.size = 0; // keep一个size变量判断是否需要删node
        this.capacity = capacity;

        head = new DLinkedNode();
        // head.prev = null;
        tail = new DLinkedNode();
        // tail.prev = null;
        head.next = tail;
        tail.prev = head;
    }
    // get和put如果之前存在node，那么一定要在最后call一个moveToHead(node)
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;

        // move the accessed node to the head;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);
            size++;

            if (size > capacity) {
                // pop the tail
                DLinkedNode tail = popTail(); // 把最不常使用的node删掉
                cache.remove(tail.key);
                size--;
            }
        } else {
            // update the value.
            node.value = value;
            moveToHead(node);
        }
    }
}
