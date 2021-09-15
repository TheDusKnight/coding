package leetcode.MergeSort;

// merge sort
class MergeSort {
    int[] helper;
    int[] nums;
    public int[] sortArray(int[] nums) {
        // cc
        
        this.nums = nums;
        int n = nums.length;
        helper = new int[n];
        sortArray(0, n-1);
        return nums;
    }
    
    private void sortArray(int l, int r) {
        if (l >= r) return;
        
        int mid = l + (r - l) / 2;
        sortArray(l, mid);
        sortArray(mid+1, r);
        merge(l, mid, r);
    }
    
    private void merge(int l, int mid, int r) {
        for (int i = l; i <= r; i++) {
            helper[i] = nums[i];
        }
        
        int curL = l, curR = mid+1, cur = l;
        while (curL <= mid && curR <= r) {
            if (helper[curL] < helper[curR]) {
                nums[cur++] = helper[curL++];
            } else {
                nums[cur++] = helper[curR++];
            }
        }
        
        while (curL <= mid) {
            nums[cur++] = helper[curL++];
        }

		// remaining elements on right side, not possible
        // 因为用的是inplace操作，左边走完，右边没走完但合计消耗掉了leftIndex之前的所有位置，
        // 右边剩余的元素在array里不需要改变
        // 例子：[2, 5, 3, 6]剩下的6正好在正确的位置
    }
}

// time: O(n*log(n)); space: O(n)