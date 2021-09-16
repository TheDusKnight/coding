package leetcode._0023_MergeKSortedLists;

import java.util.PriorityQueue;
import java.util.Queue;

import leetcode.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 // minHeap
class Solution3 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        Queue<ListNode> queue = new PriorityQueue<>((o1, o2) -> (o1.val-o2.val));
        for (ListNode cur: lists)
            if (cur != null) // 注意check if null
                queue.offer(cur);
        
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!queue.isEmpty()) {
            ListNode small = queue.poll();
            cur.next = small;
            cur = cur.next;
            
            if (small.next != null) { // check if null
                queue.offer(small.next);
            }
        }
        
        return dummy.next;
    }
}

// k is number of lists, log(k)是heap的最大高度
// 时间复杂度：假如总共有 N 个节点，每个节点入队出队都需要 log（k），所有时间复杂度是 O（N log（k））。
// 空间复杂度：优先队列需要 O（k）的复杂度。
