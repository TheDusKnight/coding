package leetcode._0706_DesignHashMap;

import java.util.*;

class Cell<K, V> {
    K key;
    V val;

    public Cell(K key, V val) {
        this.key = key;
        this.val = val;
    }

    @Override
    public int hashCode() {
        return this.key == null ? 0 : this.key.hashCode();
    }

    @Override
    public boolean equals(Object o) { // null return false
        if (o instanceof Cell<?, ?>) {
            Cell<K, V> that = (Cell<K, V>) o;
            return this.key.equals(that.key); // TODO: 没有用到equals？这里有bug？
        }  else {
            return false;
        }
    }

    public boolean keyEquals(K key) {
        return this.key == null ? key == null : this.key.equals(key);
    }
}

public class MyHashMap<K, V> {
    private static final double LOAD_FACTOR = 0.75d;
    List<Cell<K, V>>[] buckets;
    int size;
    int capacity;

    public MyHashMap() {
        buckets = new ArrayList[256];
        size = 0;
        capacity = 256;
    }

    public V get(K key) {
        int idx = _hash(key);
        if (buckets[idx] == null) return null;

        for (Cell<K, V> cell: buckets[idx]) {
            if (cell != null && cell.keyEquals(key)) {
                return cell.val;
            }
        }
        return null;
    }

    public void put(K key, V val) {
        int idx = _hash(key);
        if (buckets[idx] == null) {
            buckets[idx] = new ArrayList<>();
        }

        for (Cell<K, V> cell: buckets[idx]) {
            // replace duplicate cell
            if (cell != null && cell.keyEquals(key)) {
                cell.val = val;
                return;
            }
        }
        // add new cell
        buckets[idx].add(new Cell(key, val));
        this.size++;
        if (this.size >= this.capacity * this.LOAD_FACTOR) {
            rehash();
        }
    }

    public boolean remove(K key) {
        int idx = _hash(key);
        if (buckets[idx] == null) return false;

        List<Cell<K, V>> list = buckets[idx];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null && list.get(i).keyEquals(key)) {
                // swap
                Cell<K, V> tmp= list.get(i);
                list.set(i, list.get(list.size()-1));
                list.set(list.size()-1, tmp);
                list.remove(list.size()-1);
                this.size--;
                return true;
            }
        }
        return false;
    }

    private int _hash(K key) {
        if (key == null) return 0;

        return (Math.abs(key.hashCode() % this.capacity));
    }

    private void rehash() {
        this.capacity *= 2;
        List<Cell<K, V>>[] newBuckets = new ArrayList[this.capacity];
        for (List<Cell<K, V>> bucket: this.buckets) {
            for (Cell<K, V> cell: bucket) {
                if (cell != null) {
                    int newIdx = _hash(cell.key);
                    if (newBuckets[newIdx] == null) {
                        newBuckets[newIdx] = new ArrayList<>();
                    }
                    // 不需要去重，因为已经检查过了
                    newBuckets[newIdx].add(cell);
                }
            }
        }
        this.buckets = newBuckets;
    }

    public static void main(String[] args) {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("1", "hello");
        map.put("2453245234534", "world");
        System.out.println(map.get("2453245234534"));
        map.remove("2453245234534");
        System.out.println(map.get("2453245234534"));
        map.put("2453245234534", "ok");
        System.out.println(map.get("2453245234534"));
    }
}
