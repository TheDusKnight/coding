package leetcode._0347_TopKFrequentElements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// quick select

class Solution2 {
    int[] unique;
    int k;
    Random rand;
    Map<Integer, Integer> map;
    public int[] topKFrequent(int[] nums, int k) {
        // cc
        
        this.k = k;
        rand = new Random();
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        unique = new int[map.size()];
        int i = 0;
        for (int n: map.keySet()) unique[i++] = n;
        
        quickSelect(0, unique.length - 1);
        int[] res = Arrays.copyOfRange(unique, unique.length-k, unique.length);
        return res;
    }
    
    private void quickSelect(int l, int r) {
        // if (l > r) return; // 非必要
        
        int pivotIdx = l + rand.nextInt(r - l +1);
        int pivotVal = map.get(unique[pivotIdx]);
        swap(pivotIdx, r);
        int slow = l, fast = l;
        
        while (fast <= r) {
            if (map.get(unique[slow]) < pivotVal) {
                slow++;
            } else if (map.get(unique[fast]) < pivotVal) {
                swap(slow, fast);
                slow++;
            }
            fast++;
        }
        swap(slow, r);
        
        if (slow == unique.length - k) return;
        else if (slow < unique.length - k) quickSelect(slow+1, r);
        else quickSelect(l, slow-1);
    }
    
    private void swap(int a, int b) {
        int tmp = unique[a];
        unique[a] = unique[b];
        unique[b] = tmp;
    }
}

// time: O(N) ~ O(n^2); space: O(N)
