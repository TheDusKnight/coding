package leetcode.QuickSort;

import java.util.Arrays;

public class QuickSort {
    public int[] quickSort(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) // 必须是>=因为mid+1在边界处有可能超过r
            return;
        // mid代表mid左边小于pivot，右边大于pivot
        int mid = partition(nums, l, r);
        quickSort(nums, l, mid);
        quickSort(nums, mid + 1, r);
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        // 两头往中间边找mid边将大于pivot的数放到右边，小于pivot的数放到左边
        while (l < r) {
            while (l < r && nums[r] >= pivot) // 如果已经大于等于，收缩r，小心不要减出界
                r--;
            nums[l] = nums[r]; // swap小数到左边，不用担心l消失因为l要么是pivot要么有一个nums[r]备份
            while (l < r && nums[l] <= pivot) // 如果已经小于等于，收缩l，小心不要加出界
                l++;
            nums[r] = nums[l]; // swap大数到右边，与上面同理
        }
        nums[l] = pivot;
        return l;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        System.out.println(Arrays.toString(quickSort.quickSort(new int[] { 4, 1, 7, 2, 8, 6, 5 })));
    }
}
