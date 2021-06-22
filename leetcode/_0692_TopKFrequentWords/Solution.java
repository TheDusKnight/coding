package leetcode._0692_TopKFrequentWords;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    // minHeap k size 通过hashMap查找word frequency
    public List<String> topKFrequent(String[] words, int k) {
        // cc
        Map<String, Integer> count = new HashMap<>();
        for (String w: words) {
            count.put(w, count.getOrDefault(w, 0) + 1);
        }
        // w2.compareTo(w1)表明同frequency的word，字母大的word在minHeap比字母小的word更靠前
        // poll出来时同frequency word例如"love"在"i"前面，但是因为"love"加入头部后"i"加到"love"前面了，所以lower alphabetical order
        Queue<String> minHeap = new PriorityQueue<>((w1, w2) -> !count.get(w1).equals(count.get(w2)) ? count.get(w1)-count.get(w2) : w2.compareTo(w1));
        for (String w: count.keySet()) {
            minHeap.add(w);
            if (minHeap.size() > k) { minHeap.poll(); }
        }
        List<String> res = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            // 小数先出来，往头部加，同频率字母大的先出来;结果count由大到小
            res.add(0, minHeap.poll());
        }
        return res;
    }
}

// time: O(n*log(k)); space: O(n);
