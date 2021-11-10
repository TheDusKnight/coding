package leetcode._0300_LongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.List;

// Greedy + binary search
class Solution4 {
    public int lengthOfLIS(int[] nums) {
        // cc
        
        List<Integer> seq = new ArrayList<>(); // increasing sequence
        for (int num: nums) {
            int idx = binarySearch(seq, num);
            if (idx < seq.size()) {
                seq.set(idx, num);
            } else {
                seq.add(num);
            }
        }
        
        return seq.size();
    }
    
    private int binarySearch(List<Integer> seq, int num) {
        int start = 0, end = seq.size()-1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (seq.get(mid) == num) {
                return mid;
            } else if (seq.get(mid) < num) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        
        return start;
    }
}

// time: O(N*log(N)); space: O(N);
