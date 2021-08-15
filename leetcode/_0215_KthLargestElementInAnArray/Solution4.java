package leetcode._0215_KthLargestElementInAnArray;

import java.util.Random;

// quick selection，可以用于有duplicate的input
public class Solution4 {
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        return findPosPartition(nums, left, right, length, k);
    }

    private static int findPosPartition(int[] array, int left, int right, int length, int k) {
        // 注意base case在下面

        Random rand = new Random(); // new Random最好放到初始化的时候
        int pivotRandIndex = left + rand.nextInt(right - left + 1);
        // int pivotRandIndex = left + (int) (Math.random() * (right - left + 1)); // bad
        int pivotValue = array[pivotRandIndex];
        swap(array, pivotRandIndex, right);

        int slow = left; // slow作为边界线
        int fast = left; // fast无脑出去check

        while (fast <= right) { // 最后一轮slow需要check一下是否从fast换来的数是小数
            if (array[slow] < pivotValue) {
                slow++; // 只有当小的元素出现才++，说明slow左边是小数
            } else if (array[fast] < pivotValue) { // 把小的移到左边
                swap(array, slow, fast);
                slow++; // swap后只有当小的元素出现才++，说明slow左边是小数
            }
            fast++;
        }
        // slow index最终小数都在左边，
        swap(array, slow, right);

        // After operation, the target(pivotRandIndex) 's index is slow;
        if (slow == length - k) { // length - k是kth largest的index
            // 这里是base case，因为只走一边所以一定能touch到
            return array[slow];
            // pivot所在的位置就是从小到大sort之后的位置继续找也不需要包含pivot，由quick sort的先全局有序，后局部有序的性质决定
        } else if (slow < length - k) {
            return findPosPartition(array, slow+1, right, length, k); // 往右找
        } else {
            return findPosPartition(array, left, slow - 1, length, k); // 往左找
        }
    }

    private static void swap(int[] array, int i , int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
// time: O(n*log(n))
// space: O(1)