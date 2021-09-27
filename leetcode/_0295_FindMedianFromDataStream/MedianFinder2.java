package leetcode._0295_FindMedianFromDataStream;

import java.util.ArrayList;
import java.util.List;

// insertion sort, best when addNum call less or about equal to findMedian call
class MedianFinder2 {
    List<Integer> list;
    /** initialize your data structure here. */
    public MedianFinder2() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        if (list.isEmpty()) {
            list.add(num);
            return;
        }
        
        // 通过binary search左右越过找到需要insert的地方
        // O(log(n))
        int l = 0, r = list.size() - 1;
        while (l <= r) { // 左右越过确保left永远是更大的数，insert num to left idx
            int mid = l + (r - l) / 2;
            if (list.get(mid) == num) {
                list.add(mid, num);
                return;
            } else if (list.get(mid) < num) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        
        // O(n) shift
        list.add(l, num);
    }
    
    public double findMedian() { // O(1)
        // if (list.size() == 0) return -1.0;
        int mid = (list.size() - 1) / 2;
        return (list.size() % 2 == 1) ? (double)list.get(mid) : (double)(list.get(mid) + list.get(mid+1)) / 2.0;
    }
}

// time: add O(N + log(N)) = O(N); space: O(N)

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
