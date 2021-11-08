package leetcode._0275_HIndexII;

// 题意：ascending array, 返回第一个 nums[i] >= len - i的len-i值
// 我经过测试l应该永远不会出界, {0,1,2}值尽可能小但是l依然不会出界

class Solution {
    public int hIndex(int[] citations) {
        // cc
        
        int len = citations.length;
        int l = 0, r = len-1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (citations[mid] == len - mid) return len - mid;
            else if (citations[mid] < len - mid) l = mid+1;
            else r = mid-1;
        }
        
        return len - l;
    }
}

// time: O(log(N)); space: O(1);
