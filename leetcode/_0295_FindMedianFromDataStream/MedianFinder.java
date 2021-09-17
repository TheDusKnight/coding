package leetcode._0295_FindMedianFromDataStream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// brute force
class MedianFinder {
    List<Integer> list;
    /** initialize your data structure here. */
    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add(num);
    }
    
    public double findMedian() {
        Collections.sort(list);
        // double median;
        if (list.size() % 2 == 1) {
            return (double)list.get(list.size() / 2);
        } else {
            return (double)(list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2;
        }
    }
}

// time: O(N*log(N)); space: O(N)

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
