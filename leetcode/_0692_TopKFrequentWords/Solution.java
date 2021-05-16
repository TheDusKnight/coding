package leetcode._0692_TopKFrequentWords;
import java.util.*;

// hashmap + min-heap
public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                w2.compareTo(w1) : count.get(w1) - count.get(w2) );

        for (String word: count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll();
        }
        
        // for (String word: count.keySet()) {
        //     if (heap.size() < k) {
        //         heap.offer(word);
        //     } else {
        //         if (count.get(word) >= count.get(heap.peek())) {
        //             heap.offer(word);
        //             heap.poll();
        //         }
        //     }
        // }

        List<String> ans = new ArrayList();
        while (!heap.isEmpty()) 
            ans.add(0, heap.poll());
        return ans;
    }
}

// time: O(N*log(k))
