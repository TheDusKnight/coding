package leetcode._0432_AllO1DataStructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

// 复合型数据结构 HashMap + HashMap;
// https://leetcode.com/problems/all-oone-data-structure/discuss/219865/Java-HashMaplessInteger-HashSetlessStringgreatergreater-and-HashMaplessInteger-Stringgreater-beats-91
public class AllOne {
    HashMap<String, Integer> map;
    HashMap<Integer, HashSet<String>> bucket;
    int min, max, numElements;

    /** Initialize your data structure here. */
    public AllOne() {
        map = new HashMap<>();
        bucket = new HashMap<>();
        min = 0; max = 0;
        // 每次bucket必定从1开始，所以预先初始化
        bucket.put(1, new HashSet<>());
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) { // min和max都有可能变大
        // 更新map
        int n = map.getOrDefault(key, 0) + 1;
        map.put(key, n);

        if (n != 1) {
            bucket.get(n - 1).remove(key); // 把word从小的bucket移除
            if ((min == n - 1) &&  bucket.get(n -1).size() == 0) { // 如果最小bucket没有key并且min就是最小bucket
                min++;
            }
            if (bucket.get(n) == null) { // 检查increase后的bucket是否存在，如果没有生成new bucket
                bucket.put(n, new HashSet<>());
            }
        } else { // 当n等于1时，说明新的word出现了，并且出现的次数为1，所以min当前一定是1
            numElements++;
            min = 1;
        }
        bucket.get(n).add(key);
        if (max < n) max = n; // 如果max小于更新后的n，那么max+1
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data
     * structure.
     */
    public void dec(String key) { // min和max都有可能变小
        int n = map.getOrDefault(key, 0) - 1;
        if (n == -1) return; // 如果key不存在return或者报错
        if (n < min && n > 0) { // 如果n小于min并且n合法，注意min有可能是0
            min = n;
        }
        
        bucket.get(n + 1).remove(key); // 把word从大的bucket移除
        if (n == 0) {
            numElements--; // word的freq为0，word减少1
            if (numElements == 1) {
                min = max;
            } else if (numElements == 0) { // ?
                min = 0;
                max = 0;
            } else {
                while (bucket.get(min).isEmpty()) min++;
            }
            map.remove(key);
            return;
        }
        if (bucket.get(max).isEmpty()) max--;
        map.put(key, n);
        bucket.get(n).add(key);
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (bucket.get(max) == null) return "";
        Iterator<String> itr = bucket.get(max).iterator();
        if (!itr.hasNext()) return "";
        String r = itr.next();
        return r;
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (bucket.get(min) == null) return "";
        Iterator<String> itr = bucket.get(min).iterator();
        if (!itr.hasNext()) return "";
        String r = itr.next();
        return r;
    }
}
