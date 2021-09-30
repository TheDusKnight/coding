package leetcode._0658_FindKClosestElements;

import java.util.ArrayList;
import java.util.List;

// binary search + sliding windows
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // cc
        
        int n = arr.length;
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        List<Integer> res = new ArrayList<>();
        while (left <= right) { // 标准binary search写法
            mid = (left + right) / 2;
            if (arr[mid] == x) {
                left = mid;
                right = mid-1;
                break;
            }
            else if (arr[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        int tmp = left;
        left = right;
        right = tmp;
        // left, right开开区间
        while (right - left - 1 < k) {
            if (left == -1) {
                right += 1;
                continue;
            }
            if (right == n) {
                left -= 1;
                continue;
            }
            
            // |a - x| == |b - x|的情况下根据题意选a因为a更小
            if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                left -= 1;
            } else {
                right += 1;
            }
        }
        
        for (int i = left + 1; i < right; i++) res.add(arr[i]);
        
        return res;
    }
}

// time: O(log(N) + k); space: (1)
