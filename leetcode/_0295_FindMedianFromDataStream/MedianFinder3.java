package leetcode._0295_FindMedianFromDataStream;

import java.util.PriorityQueue;
import java.util.Queue;

// minHeap + maxHeap;
class MedianFinder3 {
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;
    /** initialize your data structure here. */
    public MedianFinder3() {
        // 维护maxHeap中的所有元素小于minHeap
        minHeap = new PriorityQueue<>((o1, o2) -> (o1 - o2));
        maxHeap = new PriorityQueue<>((o1, o2) -> (o2 - o1));
    }
    
    public void addNum(int num) {
        // 无脑先加lower, 然后把lower的最大值转给upper，反之亦然
        // maxHeap定义size不能超过minHeap size+1
        // 如果num比所有maxHeap的top小，那么没有影响，如果num比maxHeap的top大，那么它一定被poll出来放入minHeap，两个heap依然valid
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        
        // 平衡两个heap，如果minHeap size大于maxHeap，把最小值转给maxHeap
        if (minHeap.size() > maxHeap.size())
            maxHeap.offer(minHeap.poll());
    }
    
    public double findMedian() {
        return (maxHeap.size() > minHeap.size() ? (double)maxHeap.peek() : (double)(maxHeap.peek() + minHeap.peek()) / 2);
    }
}

// time: add O(log(N)), find O(1); 

// Follow-up
// 1. If all integer numbers from the stream are between 0 and 100, how would you optimize it?
// We can maintain an integer array of length 100 to store the count of each number along with a total count. Then, we can iterate over the array to find the middle value to get our median.
// Time and space complexity would be O(100) = O(1).

// 2. If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
// In this case, we need an integer array of length 100 and a hashmap for these numbers that are not in [0,100].
