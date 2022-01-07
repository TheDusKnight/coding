package leetcode._0981_TimeBasedKeyValueStore;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// treeMap
class TimeMap {
    Map<String, Map<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (map.get(key) == null) map.put(key, new TreeMap<>());
        Map<Integer, String> treeMap = map.get(key);
        treeMap.put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = (TreeMap)map.get(key);
        if (treeMap == null) return "";
        
        Integer floor = treeMap.floorKey(timestamp);
        if (floor == null) return ""; // 有可能找不到比当前timestamp小的timestamp
        return treeMap.get(floor);
    }
}

// time: set O(1), get O(log(N)). N是当前key被set的次数也就是当前treeMap的size
