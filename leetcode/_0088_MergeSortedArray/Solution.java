package leetcode._0088_MergeSortedArray;

// merge sort, two pointers
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // cc
        if (nums1 == null && nums2 == null ) return;
        if (n == 0) return;
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        
        int pointer = m+n-1;
        int left = m-1, right = n-1;
        while (left >= 0 && right >= 0) {
            if (nums1[left] < nums2[right]) {
                nums1[pointer--] = nums2[right--];
            } else {
                nums1[pointer--] = nums1[left--];
            }
        }
        
        while (left >= 0) {
            nums1[pointer--] = nums1[left--];
        }
        while (right >= 0) {
            nums1[pointer--] = nums2[right--];
        }
    }
}
// time: O(m+n)
// space: O(1)
