package leetcode.MergeSort;

import java.util.Arrays;

// 带test的array形式的MergeSort
public class MergeSort2 {
    public static int[] mergeSort(int[] array) {
        if (array == null || array.length <= 1) return array;
        
        int len = array.length;
        int[] helper = new int[len];
        mergeSort(array, helper, 0, len-1);
        return array;
    }

    private static void mergeSort(int[] array, int[] helper, int left, int right) {
        if (left >= right) { // base case永远都是这个
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(array, helper, left, mid);
        mergeSort(array, helper, mid+1, right);
        merge(array, helper, left, mid, right);
    }

    private static void merge(int[] array, int[] helper, int left, int mid, int right) {
        // reuse same helper array
        // 把当前区域的值赋给helper array
        for (int i = 0; i <= right; i++) { // i <= right而不是 i < array.length!!!
            helper[i] = array[i];
        }

        int leftIndex = left;
        int rightIndex = mid+1;
        int cur = left;
        // 相当于array在当前区间从左到右刷新了一遍
        while (leftIndex <= mid && rightIndex <= right) {
            if (helper[leftIndex] < helper[rightIndex]) {
                array[cur++] = helper[leftIndex++];
            } else {
                array[cur++] = helper[rightIndex++];
            }
        } 

        // remaining elements on left side
        // 右边走完，左边没走完需要把没走完的元素依次加到array拍好序的index后面
        while (leftIndex <= mid) {
            array[cur++] = helper[leftIndex++];
        }
        // remaining elements on right side, not possible
        // 因为用的是inplace操作，左边走完，右边没走完但合计消耗掉了leftIndex之前的所有位置，
        // 右边剩余的元素在array里不需要改变
        // 例子：[2, 5, 3, 6]剩下的6正好在正确的位置
        // while (rightIndex <= right) {
        //     array[cur++] = helper[rightIndex++];
        // }
    }

    public static void main(String[] args) {
        int[] array = null;

        // array = new int[] {2,4,1,5,3};
        array = new int[] {1,2,3,6,5,4};
        array = MergeSort2.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}

// time: O(n*log(n)); space: O(n)