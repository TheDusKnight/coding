package leetcode._0170_TwoSumIIIDataStructureDesign;

import java.util.HashMap;

// Hashmap记录出现次数解决自己跟自己complement的问题
class TwoSum {
    HashMap<Integer, Integer> map;
    public TwoSum() {
        map = new HashMap<>();
    }
    
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    public boolean find(int value) {
        for (Integer key: map.keySet()) {
            int comp = value - key;
            if (comp != key) {
                if (map.containsKey(comp))
                    return true;
            } else {
                if (map.get(key) >= 2)
                    return true;
            }
        }
        
        return false;
    }
}

// time: O(N); space: O(N);

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
