package leetcode._0215_KthLargestElementInAnArray;

// quick selection
public class Solution4 {
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        return findPosPartition(nums, left, right, length, k);
    }

    private static int findPosPartition(int[] array, int left, int right, int length, int k) {
        int pivotRandIndex = left + (int) (Math.random() * (right - left + 1));
        int pivotValue = array[pivotRandIndex];
        swap(array, pivotRandIndex, right);

        int slow = left;
        int fast = left;

        while (fast <= right) {
            if (array[slow] < pivotValue) {
                slow++;
            } else if (array[fast] < pivotValue) {
                swap(array, slow, fast);
                slow++;
            }
            fast++;
        }
        swap(array, slow, right);

        // After operation, the target(pivotRandIndex) 's index is slow;
        if (slow == length - k) {
            return array[slow];
        } else if (slow < length - k) {
            return findPosPartition(array, slow+1, right, length, k);
        } else {
            return findPosPartition(array, left, slow - 1, length, k);
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