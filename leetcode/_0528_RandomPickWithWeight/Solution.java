package leetcode._0528_RandomPickWithWeight;

import java.util.Random;

// Cumulative Possibility
// prob + binary search
class Solution {
    int totalWeight;
    Range[] ranges;
    
    class Range {
        int upper;
        int lower;
        // range顺序写错了
        public Range(int lower, int upper) {
            this.upper = upper;
            this.lower = lower;
        }
    }
    
    public Solution(int[] w) {
        // cc
        
        totalWeight = 0;
        ranges = new Range[w.length];
        for (int i = 0; i < w.length; i++) {
            // 闭开区间没搞清楚
            ranges[i] = new Range(totalWeight, totalWeight+w[i]-1);
            totalWeight += w[i];
        }
    }
    
    public int pickIndex() {
        int pick = new Random().nextInt(totalWeight);
        int start = 0, end = ranges.length-1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (ranges[mid].upper >= pick && ranges[mid].lower <= pick) {
                return mid;
            } else if (ranges[mid].upper < pick) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        
        throw new RuntimeException("you should not get this message");
    }
}

// time: O(N) init + O(log(N)) pickIndex();
// space: O(N);

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
