package leetcode._0373_FindKPairsWithSmallestSums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

// 类似378. Kth Smallest Element in a Sorted Matrix
// minHeap
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // cc
        
        int row = nums1.length, col = nums2.length;
        
        List<List<Integer>> res = new ArrayList<>();
        Queue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> ((nums1[o1[0]]+nums2[o1[1]]) - (nums1[o2[0]]+nums2[o2[1]])));
        Set<Integer> visited = new HashSet<>();
        minHeap.offer(new int[]{0,0});
        visited.add(0 * col + 0);
        
        while (k-- > 0) {
            if (minHeap.isEmpty()) return res;
            int[] cur = minHeap.poll();
            int i = cur[0];
            int j = cur[1];
            
            res.add(Arrays.asList(nums1[i], nums2[j]));
            
            if (i+1 < row && !visited.contains((i+1) * col + j)) {
                visited.add((i+1) * col + j);
                minHeap.offer(new int[] {i+1, j});
            }
            if (j+1 < col && !visited.contains(i*col + j+1)) {
                visited.add(i*col + j+1);
                minHeap.offer(new int[] {i, j+1});
            }
        }
        
        return res;
    }
}

// time: O(k*log(min(m+n, k))); space: O(k + min(m+n, k)) -> O(min(m+n, k))
