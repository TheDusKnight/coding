package leetcode._0146_LRUCache;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    class DLinkedNode {
        int key;
        int val;
        DLinkedNode pre;
        DLinkedNode next;
    }
    
    public void addNode(DLinkedNode cur) {
        cur.pre = head;
        cur.next = head.next;
        head.next.pre = cur;
        head.next = cur;
    }
    
    public void removeNode(DLinkedNode cur) {
        DLinkedNode pre = cur.pre;
        DLinkedNode next = cur.next;
        pre.next = next;
        next.pre = pre;
    }
    
    public void moveToHead(DLinkedNode cur) {
        removeNode(cur);
        addNode(cur);
    }
    
    public DLinkedNode popTail() {
        DLinkedNode last = tail.pre;
        removeNode(last);
        return last;
    }

    int capacity, size;
    DLinkedNode head, tail;
    Map<Integer, DLinkedNode> map;
    
    public LRUCache(int capacity) {
        // cc
        size = 0;
        this.capacity = capacity;
        head = new DLinkedNode(); tail = new DLinkedNode();
        map = new HashMap<>();
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        DLinkedNode cur = map.get(key);
        if (cur == null) return -1;
        moveToHead(cur);
        return cur.val;
    }
    
    public void put(int key, int value) {
        DLinkedNode cur = map.get(key);
        if (cur != null) {
            cur.val = value;
            moveToHead(cur);
            return;
        }
        
        cur = new DLinkedNode();
        cur.key = key; cur.val = value;
        addNode(cur);
        map.put(key, cur);
        size++;
        
        if (size > capacity) {
            DLinkedNode last = popTail();
            removeNode(last);
            map.remove(last.key);
            size--;
        }
    }
}

// time: O(1); space: O(capacity);