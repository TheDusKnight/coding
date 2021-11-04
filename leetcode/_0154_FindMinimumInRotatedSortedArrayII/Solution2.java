package leetcode._0154_FindMinimumInRotatedSortedArrayII;

// 自写binary search
class Solution2 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException();
        if (nums.length == 1) return nums[0];
        
        int n = nums.length;
        int left = 0, right = n-1, minVal = nums[0];
        // 有且只有当最左和最右值相等时，分界线左右区域同时出现了相同值则无法判断当前值所处区域
        if (nums[left] == nums[right]) {
            for (int i = 1; i < n; i++) {
                minVal = Math.min(minVal, nums[i]);
            }
            return minVal;
        }
        // 单调升序时left一定是最小
        if (nums[left] < nums[right]) return nums[left];
        // 其他情况使用lc153代码
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[0]) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        
        return nums[left];
    }
}

// time: O(log(N) ~ O(N)); space: O(1);
