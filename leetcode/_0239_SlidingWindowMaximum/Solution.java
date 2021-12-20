package leetcode._0239_SlidingWindowMaximum;

import java.util.Deque;
import java.util.LinkedList;

// 亚麻OA高频
// brute force check max in sliding window every time O(kn)
// improve: use stack -> deque
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // cc
        
        int len = nums.length;
        if (len == 0) return new int[0];
        int[] res = new int[len-k+1];
        Deque<Integer> que = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            // 把超出滑动窗口的元素去掉
            if (i >= k && que.getFirst() == i - k)
                que.pollFirst();
            // 先remove再加
            // remove the useless data from the queue, if nums[getLast()] < nums[i],
            // then from now on, nums[getLast()] must not be a max element, so remove it
            while (!que.isEmpty() && nums[que.getLast()] <= nums[i])
                que.pollLast();
            // 每次无脑往deque尾部加idx
            que.offerLast(i);
            
            if (i >= k-1)
                res[i-k+1] = nums[que.getFirst()];
        }
        
        return res;
    }
}

// time: O(N); space: O(N);