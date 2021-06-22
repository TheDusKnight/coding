package leetcode._0215_KthLargestElementInAnArray;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution3 {
    // maxHeap
    public int findKthLargest(int[] nums, int k) {
        // cc
        Queue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> (n2 - n1));
        for (int num: nums) {
            maxHeap.add(num);
        }
        int tmp = 0;
        while (k-- > 0) {
            tmp = maxHeap.poll();
        }
        return tmp;
    }
}

// time: O(n*log(n))
