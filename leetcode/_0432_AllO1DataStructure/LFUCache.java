package leetcode._0432_AllO1DataStructure;

import java.util.HashMap;
import java.util.LinkedHashSet;

// 复合数据结构 3 HashMaps and LinkedHashSet
// https://leetcode.com/problems/lfu-cache/discuss/94521/JAVA-O(1)-very-easy-solution-using-3-HashMaps-and-LinkedHashSet
// 批注加得不错
public class LFUCache {
    private int min;
    private final HashMap<Integer, Integer> keyToVal;
    private final HashMap<Integer, Integer> keyToCount;
    private final HashMap<Integer, LinkedHashSet<Integer>> countToLRUKeys;
    
    public LFUCache(int capacity) {
        this.min = -1;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        
    }
    
    public void put(int key, int value) {
        
    }
}
