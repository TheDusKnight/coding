package leetcode._0706_DesignHashMap;

import java.util.LinkedList;

class Pair<U, V> { // 泛型例子
    public U first;
    public V second;
    
    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}

class MyHashMap {
    private int keyRange;
    private Bucket[] bucketArray;

    /** Initialize your data structure here. */
    public MyHashMap() {
        this.keyRange = 2069; // 769
        this.bucketArray = new Bucket[this.keyRange];
        for (int i = 0; i < this.keyRange; i++) {
            this.bucketArray[i] = new Bucket();
        }
    }
    
    protected int _hash(int key) {
        return (key % keyRange);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int idx = _hash(key);
        bucketArray[idx].update(key, value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int idx = _hash(key);
        return bucketArray[idx].get(key);
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int idx = _hash(key);
        bucketArray[idx].remove(key);
    }
}

class Bucket {
    private LinkedList<Pair> bucket;
    
    public Bucket() {
        bucket = new LinkedList<>();
    }
    
    public Integer get(Integer key) { // 注意传的是Integer
        for (Pair<Integer, Integer> pair: bucket) {
            if (pair.first.equals(key))
                return pair.second;
        }
        return -1;
    }
    
    public void update(Integer key, Integer value) {
        boolean found = false;
        for (Pair<Integer, Integer> pair: bucket) {
            if (pair.first.equals(key)) {
                pair.second = value;
                found = true;
                break;
            }
        }
        if (!found) {
            bucket.addFirst(new Pair<Integer, Integer>(key, value));
        }
    }
    
    public void remove(Integer key) {
        for (Pair<Integer, Integer> pair: bucket) {
            if (pair.first.equals(key)) {
                bucket.remove(pair); // 这里是remove pair不是remove key
                break;
            }
        }
    }
}

// time: O(N / K). N is number of elements in hashMap, K is keyRange. N/K是每个bucket的平均长度，worst case O(1)找到 bucket，linkedList使用O(N/K)找到target;
// space: O(K + M). K is the predefined buckets, M is the number of unique values in hashSet;

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
