package leetcode._0692_TopKFrequentWords;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// minHeap
class Solution {
    Map<String, Integer> map;
    public List<String> topKFrequent(String[] words, int k) {
        // cc
        
        map = new HashMap<>();
        for (String s: words) map.put(s, map.getOrDefault(s, 0) + 1);
        // w2.compareTo(w1)表明同frequency的word，字母大的word在minHeap比字母小的word更靠前
        // poll出来时同frequency word例如"love"在"i"前面，但是因为"love"加入头部后"i"加到"love"前面了，所以lower alphabetical orde
        Queue<String> queue = new PriorityQueue<>((o1, o2) -> { 
            if (map.get(o1).equals(map.get(o2))) return o2.compareTo(o1);
            return map.get(o1) - map.get(o2);
        });
        for (String s: map.keySet()) {
            queue.offer(s);
            if (queue.size() > k) queue.poll();
        }
        
        List<String> res = new LinkedList<>();
        // 小数先出来，往头部加，同频率字母大的先出来;结果count由大到小
        while (k-- > 0) res.add(0, queue.poll());
        return res;
    }
}

// time: O(N*log(K)); space: O(N);
