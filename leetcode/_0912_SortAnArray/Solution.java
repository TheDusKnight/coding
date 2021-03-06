package leetcode._0912_SortAnArray;

import java.util.Random;

// 215 quick selection改进写法速度更快
// 也可以用双指针站肩
public class Solution {
    Random rand;
    public int[] sortArray(int[] nums) {
        // cc
        
        rand = new Random();
        int l = 0, r = nums.length - 1;
        quickSort(nums, l, r);
        return nums;
    }
    
    private void quickSort(int[] nums, int l, int r) {
        if (l > r) return; // l >= r也能通过
        
        int pivotIdx = l + rand.nextInt(r - l + 1);
        int pivotVal = nums[pivotIdx];

        swap(nums, pivotIdx, r);
        int slow = l, fast = l;
        
        // 用for loop更好？
        while (fast <= r) { // 把小于pivotVal的值都放大左边
            if (nums[slow] < pivotVal) {
                slow++;
            } else if (nums[fast] < pivotVal) {
                swap(nums, slow, fast);
                slow++;
            }
            fast++;
        }
        swap(nums, slow, r);
        
        quickSort(nums, l, slow - 1);
        quickSort(nums, slow + 1, r);
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
