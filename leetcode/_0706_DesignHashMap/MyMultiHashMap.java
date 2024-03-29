package leetcode._0706_DesignHashMap;

import java.util.*;

public final class MyMultiHashMap<K, V> {
    private static final class MultiCell<K, V> {
        private final K key;
        private List<V> vals;

        public MultiCell(K key, V val) {
            this.key = key;
            this.vals = new ArrayList<>();
            this.vals.add(val);
        }

        public K getKey() {
            return this.key;
        }

        public List<V> getVals() {
            return this.vals;
        }

        public void addVal(V val) {
            this.vals.add(val);
        }

        public boolean keyEquals(K key) { // 比较只使用到key不需要传入Cell obj
            return this.key == null ? key == null : this.key.equals(key);
        }
    }

    private static final double LOAD_FACTOR = 0.75d;
    private List<MultiCell<K, V>>[] buckets;
    private int capacity;
    private int size;

    public MyMultiHashMap() {
        this(256);
    }

    public MyMultiHashMap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must larger than 0");
        }

        buckets = new ArrayList[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public List<V> get(K key) { // return null说明没找到
        int idx = hashing(key);
        if (buckets[idx] == null) {
            return null;
        }

        for (MultiCell<K, V> cell : buckets[idx]) {
            if (cell.keyEquals(key)) {
                return cell.getVals();
            }
        }
        return null;
    }

    public void put(K key, V val) {
        int idx = hashing(key);
        if (buckets[idx] == null) {
            buckets[idx] = new ArrayList<>();
        }

        for (MultiCell<K, V> cell : buckets[idx]) {
            if (cell.keyEquals(key)) {
                cell.addVal(val);
                return;
            }
        }
        buckets[idx].add(new MultiCell(key, val));
        this.size++;
        // rehash要放到最后做不然index对应的bucket会变
        if (this.size >= this.capacity * MyMultiHashMap.LOAD_FACTOR) {
            rehashing();
        }
    }

    public boolean remove(K key) { // return false说明没找到
        int idx = hashing(key);
        if (buckets[idx] == null) {
            return false;
        }

        List<MultiCell<K, V>> list = buckets[idx];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).keyEquals(key)) {
                // swap
                MultiCell<K, V> tmp = list.get(i);
                list.set(i, list.get(list.size() - 1));
                list.set(list.size() - 1, tmp);
                list.remove(list.size() - 1);
                this.size--;
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    private int hashing(K key) {
        if (key == null)
            return 0;

        return (Math.abs(key.hashCode() % this.capacity));
    }

    private void rehashing() {
        this.capacity *= 2;
        List<MultiCell<K, V>>[] newBuckets = new ArrayList[this.capacity];
        for (List<MultiCell<K, V>> bucket : this.buckets) {
            if (bucket == null)
                continue;
            for (MultiCell<K, V> cell : bucket) {
                int newIdx = hashing(cell.getKey());
                if (newBuckets[newIdx] == null) {
                    newBuckets[newIdx] = new ArrayList<>();
                }
                // 不需要去重，因为已经检查过了
                newBuckets[newIdx].add(cell);
            }
        }
        this.buckets = newBuckets;
    }

    public MyHashMap<K, List<V>> asMap() {
        MyHashMap<K, List<V>> myHashMap = new MyHashMap<>();

        for (List<MultiCell<K, V>> bucket : buckets) {
            if (bucket == null) {
                continue;
            }
            for (MultiCell<K, V> cell : bucket) {
                myHashMap.put(cell.getKey(), cell.getVals());
            }
        }
        return myHashMap;
    }

    public static void main(String[] args) {
        MyMultiHashMap<Student, String> map2 = new MyMultiHashMap<>(5);
        Student s1 = new Student("1");
        Student s2 = new Student("2");
        Student s3 = new Student("1");
        Student s4 = new Student("4");
        Student s5 = new Student("5");
        Student s6 = new Student("4");
        map2.put(s1, "Sam");
        System.out.println(map2.get(s1)); // [Sam]
        map2.put(s2, "Tom");
        System.out.println(map2.get(s2)); // [Tom]
        System.out.println(map2.remove(s2)); // true
        System.out.println(map2.get(s2)); // null
        System.out.println(map2.remove(s2)); // false
        map2.put(s1, "Alex");
        System.out.println(map2.get(s1)); // [Sam, Alex]
        map2.put(s3, "Bill");
        System.out.println(map2.getSize()); // 1
        System.out.println(map2.get(s1)); // [Sam, Alex, Bill]
        System.out.println(map2.get(s3)); // [Sam, Alex, Bill]

        map2.put(s2, "Apple");
        map2.put(s3, "Banana");
        map2.put(s4, "Cat");
        map2.put(s5, "Dog");
        map2.put(s6, "Eat");
        map2.put(s2, "Angel");
        System.out.println(map2.getSize()); // 4
        System.out.println(map2.getCapacity()); // 10
        System.out.println(map2.get(s1)); // [Sam, Alex, Bill, Banana]
        System.out.println(map2.get(s2)); // [Apple, Angel]
        System.out.println(map2.get(s3)); // [Sam, Alex, Bill, Banana]
        System.out.println(map2.get(s4)); // [Cat, Eat]
        System.out.println(map2.get(s5)); // [Dog]
        System.out.println(map2.get(s6)); // [Cat, Eat]

        System.out.println(map2.remove(s5)); // true
        System.out.println(map2.get(s5)); // null
        System.out.println(map2.get(s6)); // [Cat, Eat]
        System.out.println(map2.getSize()); // 3
        System.out.println(map2.getCapacity()); // 10

    }
}
