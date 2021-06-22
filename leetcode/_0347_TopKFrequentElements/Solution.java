package leetcode._0347_TopKFrequentElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    // requirement: better than O(n*log(n)), return the answer in any order
    // minHeap + hashMap same as 692
    public int[] topKFrequent(int[] nums, int k) {
        // cc
        Map<Integer, Integer> count = new HashMap<>();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0)+1);
        }
        Queue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> (count.get(n1) - count.get(n2)));
        
        for (Integer i: count.keySet()) {
            minHeap.add(i);
            if (minHeap.size() > k) { minHeap.poll(); }
        }
        
        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = (int)minHeap.poll();
        }
        return res;
    }
}

// time: O(n*log(k)); space: O(n);
