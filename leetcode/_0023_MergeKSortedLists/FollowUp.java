package leetcode._0023_MergeKSortedLists;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// Merge k Sorted Array
public class FollowUp {
    public List<Integer> mergeKArrays(int[][] arr) {
        // cc

        int len = arr.length;
        Queue<int[]> minHeap = new PriorityQueue<>((o1, o2) ->
         (arr[o1[0]][o1[1]] - arr[o2[0]][o2[1]]));
        for (int i = 0; i < len; i++) {
            if (arr[i].length > 0)
                minHeap.offer(new int[]{i, 0});
        }

        List<Integer> res = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            int[] pos = minHeap.poll();
            res.add(arr[pos[0]][pos[1]]);
            if (pos[1]+1 < arr[pos[0]].length)
                minHeap.offer(new int[] {pos[0], pos[1]+1});
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,4,5}, {}, {2,6}};
        FollowUp followUp = new FollowUp();
        System.out.println(followUp.mergeKArrays(arr).toString());
    }
}
