package leetcode._0460_LFUCache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

// 复合数据结构 3 HashMaps and LinkedHashSet
// https://leetcode.com/problems/lfu-cache/discuss/94521/JAVA-O(1)-very-easy-solution-using-3-HashMaps-and-LinkedHashSet
// 批注加得不错
public class LFUCache {
    private int min;
    private final int capacity;
    private final Map<Integer, Integer> keyToVal;
    private final Map<Integer, Integer> keyToCount;
    private final Map<Integer, LinkedHashSet<Integer>> countToLRUKeys;

    public LFUCache(int capacity) {
        this.min = -1;
        this.capacity = capacity;
        this.keyToVal = new HashMap<>();
        this.keyToCount = new HashMap<>();
        this.countToLRUKeys = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key))
            return -1;

        int count = keyToCount.get(key);
        countToLRUKeys.get(count).remove(key); // remove key from current count (since we will inc count)
        if (count == min && countToLRUKeys.get(count).size() == 0)
            min++; // nothing in the current min bucket

        putCount(key, count + 1);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0)
            return;

        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value); // update key's value
            get(key); // update key's count
            return;
        }
        // 如果key没有加过，check是否需要evict LFU key
        if (keyToVal.size() >= capacity) // 注意这里是大于等于
            evict(countToLRUKeys.get(min).iterator().next()); // evict LRU from this min count bucket

        min = 1; // min will always reset to 1 when adding a new item
        keyToVal.put(key, value); // adding new key and value
        putCount(key, min); // adding new key and count
    }

    private void evict(int key) {
        countToLRUKeys.get(min).remove(key);
        keyToVal.remove(key);
        keyToCount.remove(key);
    }

    private void putCount(int key, int count) { // 不需要更新keyToVal因为之前更新过了
        keyToCount.put(key, count);
        countToLRUKeys.computeIfAbsent(count, k -> new LinkedHashSet<>());
        countToLRUKeys.get(count).add(key);
    }
}
