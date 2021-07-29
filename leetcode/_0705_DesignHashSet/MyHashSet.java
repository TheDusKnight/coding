package leetcode._0705_DesignHashSet;

import java.util.LinkedList;


public class MyHashSet {
    private Bucket[] bucketArray;
    private int keyRange;

    /** Initialize your data structure here. */
    public MyHashSet() {
        this.keyRange = 769;
        this.bucketArray = new Bucket[this.keyRange];
        
        for (int i = 0; i < this.keyRange; i++) {
            this.bucketArray[i] = new Bucket();
        }
    }

    protected int _hash(int key) {
        return (key % keyRange);
    }
    
    public void add(int key) {
        int bucketIdx = _hash(key);
        bucketArray[bucketIdx].insert(key);
    }
    
    public void remove(int key) {
        int bucketIdx = _hash(key);
        bucketArray[bucketIdx].delete(key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketIdx = _hash(key);
        return bucketArray[bucketIdx].exists(key);
    }
}

class Bucket {
    private LinkedList<Integer> container;
    
    public Bucket() {
        container = new LinkedList<Integer>();
    }

    public void insert(Integer key) {
        int idx = container.indexOf(key);
        if (idx == -1) { // 只有不存在是才添加，查重
            container.addFirst(key); // addFirst或者addLast都行
        }
    }

    public void delete(Integer key) {
        container.remove(key); // 注意LinkedList remove API input为int是remove by index，input为Object是remove by Element
    }

    public boolean exists(Integer key) {
        int idx = container.indexOf(key);
        return (idx != -1);
    }
}

// time: O(N / K). N is number of elements in hashSet, K is keyRange. N/K是每个bucket的平均长度，worst case O(1)找到 bucket，linkedList使用O(N/K)找到target;
// space: O(K + M). K is the predefined buckets, M is the number of unique values in hashSet;

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
