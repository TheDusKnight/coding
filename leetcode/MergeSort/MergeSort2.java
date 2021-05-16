package leetcode.MergeSort;

import java.util.Arrays;

// 带test的array形式的MergeSort
public class MergeSort2 {
    public static int[] mergeSort(int[] array) {
        // cc
        int len = array.length;
        if (array == null || len <= 1) return array;
        
        int[] helper = new int[len];
        mergeSort(array, helper, 0, len-1);
        return array;
    }

    private static void mergeSort(int[] array, int[] helper, int left, int right) {
        if (left == right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(array, helper, left, mid);
        mergeSort(array, helper, mid+1, right);
        merge(array, helper, left, mid, right);
    }

    private static void merge(int[] array, int[] helper, int left, int mid, int right) {
        // reuse same helper array
        for (int i = 0; i <= right; i++) {
            helper[i] = array[i];
        }

        int leftIndex = left;
        int rightIndex = mid+1;
        int cur = left;
        while (leftIndex <= mid && rightIndex <= right) {
            if (helper[leftIndex] < helper[rightIndex]) {
                array[cur++] = helper[leftIndex++];
            } else {
                array[cur++] = helper[rightIndex++];
            }
        } 

        // remaining elements on left side
        while (leftIndex <= mid) {
            array[cur++] = helper[leftIndex++];
        }
        // remaining elements on right side, not possible
    }

    public static void main(String[] args) {
        int[] array = null;

        array = new int[] {2,4,1,5,3};
        array = MergeSort2.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}

