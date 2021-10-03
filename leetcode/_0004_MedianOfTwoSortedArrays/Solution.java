package leetcode._0004_MedianOfTwoSortedArrays;

// binary search
// https://zhuanlan.zhihu.com/p/70654378
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) { // ensure n >= m
            return findMedianSortedArrays(nums2, nums1);
        }
        // i初始区间为[0,m]
        // half意味着左区间的总长度
        int i = 0, j = 0, imin = 0, imax = m, half = (m + n + 1) / 2;
        int maxLeft = 0, minRight = 0;
        while (imin <= imax) {
            // i代表左区间上半部分的长度，j代表左区间下半部分的长度，合起来是做区间的长度
            i = (imin + imax) / 2; // 找mid idx
            j = half - i;
            if (j > 0 && i < m && nums2[j - 1] > nums1[i]) {
                imin = i + 1;
            } else if (i > 0 && j < n && nums1[i - 1] > nums2[j]) {
                imax = i - 1;
            } else { // i is perfect
                if (i == 0) { // 边界判定
                    maxLeft = nums2[j - 1];
                } else if (j == 0) { // 边界判定
                    maxLeft = nums1[i - 1];
                } else { // target find
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                break;
            }
        }
        // odd直接返回maxLeft因为左边永远比右边多一个数，这个数就是maxLeft
        if ((m + n) % 2 == 1) {
            return (double) maxLeft;
        }

        if (i == m) { // 边界判定
            minRight = nums2[j];
        } else if (j == n) { // 边界判定
            minRight = nums1[i];
        } else {
            minRight = Math.min(nums1[i], nums2[j]);
        }

        return (maxLeft + minRight) / 2.0;
    }
}

// time: O(log(m+n)); space: O(1);

