package leetcode._0380_InsertDeleteGetRandomO1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random rand;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        // 注意先check validation, 如果出现duplicate，根据题意return false
        if (map.containsKey(val)) return false;
        
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        
        int lastElem = list.get(list.size() - 1);
        int idx = map.get(val);
        list.set(idx, lastElem);
        // map更新lastElem的位置
        map.put(lastElem, idx);
        // lastElement更新位置后delete the last element
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

// time: average O(1), worest case O(n) when the operation exceeds the capacity of currently allocated array/hashmap and invokes space reallocation; space: O(n)

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */