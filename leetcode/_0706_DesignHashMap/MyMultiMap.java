package leetcode._0706_DesignHashMap;

import java.util.*;

class MultiCell<K, V> { // Sol1: change cell to multi cell
    K key;
    List<V> vals;

    public MultiCell(K key, V val) {
        this.key = key;
        this.vals = new ArrayList<>();
        this.vals.add(val);
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

public class MyMultiMap<K, V> {
    private static final double LOAD_FACTOR = 0.75d;
    List<MultiCell<K, V>>[] buckets;
    int size;
    int capacity;

    public MyMultiMap() {
        buckets = new ArrayList[256];
        size = 0;
        capacity = 256;
    }

    public List<V> get(K key) { // Sol2: Mutli Map可以允许duplicate
        int idx = _hash(key);
        if (buckets[idx] == null) return null;

        for (MultiCell<K, V> cell: buckets[idx]) {
            if (cell != null && cell.keyEquals(key)) {
                return cell.vals;
            }
        }
        return null;
    }

    public void put(K key, V val) {
        int idx = _hash(key);
        if (buckets[idx] == null) {
            buckets[idx] = new ArrayList<>();
        }

        for (MultiCell<K, V> cell: buckets[idx]) {
            // add val to existing multi cell
            if (cell != null && cell.keyEquals(key)) {
                cell.vals.add(val); // 注意这里是add val到list不是set val
                return;
            }
        }
        // add new multi cell
        buckets[idx].add(new MultiCell(key, val));
        this.size++;
        if (this.size >= this.capacity * this.LOAD_FACTOR) {
            rehash();
        }
    }

    public boolean remove(K key) {
        int idx = _hash(key);
        if (buckets[idx] == null) return false;

        List<MultiCell<K, V>> list = buckets[idx];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null && list.get(i).keyEquals(key)) {
                // swap
                MultiCell<K, V> tmp= list.get(i);
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
        List<MultiCell<K, V>>[] newBuckets = new ArrayList[this.capacity];
        for (List<MultiCell<K, V>> bucket: this.buckets) {
            for (MultiCell<K, V> cell: bucket) {
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
        MyMultiMap<String, String> map = new MyMultiMap<>();
        map.put("1", "hello");
        map.put("2453245234534", "world");
        System.out.println(map.get("2453245234534"));
        map.remove("2453245234534");
        System.out.println(map.get("2453245234534"));
        map.put("2453245234534", "ok");
        System.out.println(map.get("2453245234534"));
        map.put("2453245234534", "okk");
        System.out.println(map.get("2453245234534"));
    }
}
