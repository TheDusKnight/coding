package leetcode._0540_SingleElementInASortedArray;

// binary search
class Solution {
    public int singleNonDuplicate(int[] nums) {
        // cc
        
        int len = nums.length;
        int start = 0, end = len-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid+1 < len && nums[mid] == nums[mid+1]) {
                if (mid % 2 == 0) start = mid+1;
                else end = mid-1;
            } else if (mid-1 >= 0 && nums[mid] == nums[mid-1]) {
                if (mid % 2 == 1) start = mid+1;
                else end = mid-1;
            } else {
                return nums[mid];
            }
        }
        
        throw new IllegalArgumentException();
    }
}

// time: O(log(N)); space: O(1);
