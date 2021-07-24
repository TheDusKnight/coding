package leetcode._0146_LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

// Java 内置LinkedHashMap

public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;
    
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        super.put(key, value);
    }
    
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity; // 当 map的size大于设定的capacity开始remove eldest
    }
}

// time: O(1); space: O(capacity);

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
