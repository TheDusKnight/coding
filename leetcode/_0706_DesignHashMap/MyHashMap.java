package leetcode._0706_DesignHashMap;

import java.util.*;

final class Student {
    private final String id;

    public Student(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public int hashCode() {
        return this.id == null ? 0 : this.id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Student)) {
            return false;
        }

        Student that = (Student) o;
        return this.id == null ? that.id == null : this.id.equals(that.id);
    }
}

final class SingleCell<K, V> {
    private final K key;
    private V val;

    public SingleCell(K key, V val) {
        this.key = key;
        this.val = val;
    }

    public K getKey() {
        return this.key;
    }

    public V getVal() {
        return this.val;
    }

    public void setVal(V val) {
        this.val = val;
    }

    // 只有当map key是Cell才需要override hashCode()和equals()

    // @Override
    // public int hashCode() {
    // // if this.key = null return任意bucket index不影响结果
    // return this.key == null ? 0 : this.key.hashCode();
    // }

    // @Override
    // public boolean equals(Object o) { // if input is null, return false
    // if (o == this)
    // return true;
    // if (o instanceof Cell<?, ?>) {
    // Cell<K, V> that = (Cell<K, V>) o;
    // return keyEquals(that.key);
    // }
    // return false;
    // }

    public boolean keyEquals(K key) { // 比较只使用到key不需要传入Cell obj
        return this.key == null ? key == null : this.key.equals(key);
    }
}

public final class MyHashMap<K, V> {
    private static final int INIT_MAP_CAPACITY = 256;
    private static final int INIT_MAP_SIZE = 0;
    private static final double LOAD_FACTOR = 0.75d;
    private List<SingleCell<K, V>>[] buckets;
    private int bucketsSize;
    private int bucketsCapacity;

    public MyHashMap() {
        buckets = new ArrayList[INIT_MAP_CAPACITY];
        bucketsSize = INIT_MAP_SIZE;
        bucketsCapacity = INIT_MAP_CAPACITY;
    }

    public V get(K key) { // return null说明没找到
        int idx = _hash(key);
        if (buckets[idx] == null) {
            return null;
        }

        for (SingleCell<K, V> cell : buckets[idx]) {
            if (cell.keyEquals(key)) {
                return cell.getVal();
            }
        }
        return null;
    }

    public void put(K key, V val) {
        int idx = _hash(key);
        if (buckets[idx] == null) {
            buckets[idx] = new ArrayList<>();
        }
        if (buckets[idx].size() == 0) {
            this.bucketsSize++;
        }

        for (SingleCell<K, V> cell : buckets[idx]) {
            // replace val
            if (cell.keyEquals(key)) {
                cell.setVal(val);
                return;
            }
        }
        // add new cell
        buckets[idx].add(new SingleCell(key, val));
        // rehash要放到最后做不然index对应的bucket会变
        if (this.bucketsSize >= this.bucketsCapacity * this.LOAD_FACTOR) {
            rehash();
        }
    }

    public boolean remove(K key) { // return false说明没找到
        int idx = _hash(key);
        if (buckets[idx] == null) {
            return false;
        }

        List<SingleCell<K, V>> list = buckets[idx];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).keyEquals(key)) {
                // swap
                SingleCell<K, V> tmp = list.get(i);
                list.set(i, list.get(list.size() - 1));
                list.set(list.size() - 1, tmp);
                list.remove(list.size() - 1);
                if (list.size() == 0) {
                    this.bucketsSize--;
                }
                return true;
            }
        }
        return false;
    }

    public int getBucketsSize() {
        return this.bucketsSize;
    }

    private int _hash(K key) {
        if (key == null)
            return 0;

        return (Math.abs(key.hashCode() % this.bucketsCapacity));
    }

    private void rehash() {
        this.bucketsCapacity *= 2;
        this.bucketsSize = 0;
        List<SingleCell<K, V>>[] newBuckets = new ArrayList[this.bucketsCapacity];
        for (List<SingleCell<K, V>> bucket : this.buckets) {
            if (bucket == null)
                continue;
            for (SingleCell<K, V> cell : bucket) {
                int newIdx = _hash(cell.getKey());
                if (newBuckets[newIdx] == null) {
                    newBuckets[newIdx] = new ArrayList<>();
                    this.bucketsSize++;
                }
                // 不需要去重，因为已经检查过了
                newBuckets[newIdx].add(cell);
            }
        }
        this.buckets = newBuckets;
    }

    public static void main(String[] args) {
        // MyHashMap<String, String> map = new MyHashMap<>();
        // map.put("1", "hello");
        // map.put("2", "world");
        // System.out.println(map.get("2"));
        // map.remove("2");
        // System.out.println(map.get("2"));
        // map.put("2", "ok");
        // System.out.println(map.get("2"));

        MyHashMap<Student, String> map2 = new MyHashMap<>();
        Student s1 = new Student("1");
        Student s2 = new Student("2");
        Student s3 = new Student("1");
        map2.put(s1, "Sam");
        System.out.println(map2.get(s1)); // Sam
        map2.put(s2, "Tom");
        System.out.println(map2.get(s2)); // Tom
        System.out.println(map2.remove(s2)); // true
        System.out.println(map2.get(s2)); // null
        System.out.println(map2.remove(s2)); // false
        map2.put(s1, "Alex");
        System.out.println(map2.get(s1)); // Alex
        map2.put(s3, "Bill");
        System.out.println(map2.getBucketsSize()); // 1
        System.out.println(map2.get(s1)); // Bill
        System.out.println(map2.get(s3)); // Bill
    }
}
