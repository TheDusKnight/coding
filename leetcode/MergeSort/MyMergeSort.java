package leetcode.MergeSort;

import java.util.Arrays;

public class MyMergeSort {
    public static int[] mergeSort(int[] array) {
        // cc
        int n = array.length;
        int[] helper = new int[n];
        mergeSort(array, helper, 0, n-1);
        return array;
    }

    private static void mergeSort(int[] array, int[] helper, int l, int r) {
        if (l >= r) return;

        int mid = l + (r - l) / 2;
        mergeSort(array, helper, l, mid);
        mergeSort(array, helper, mid+1, r);
        merge(array, helper, l, mid, r);
    }

    private static void merge(int[] array, int[] helper, int l, int mid, int r) {
        for (int i = 0; i <= r; i++) {
            helper[i] = array[i];
        }

        int lIdx = l, rIdx = mid+1, curIdx = l;
        while (lIdx <= mid && rIdx <= r) {
            if (helper[lIdx] < helper[rIdx]) {
                array[curIdx++] = helper[lIdx++];
            } else {
                array[curIdx++] = helper[rIdx++];
            }
        }

        while (lIdx <= mid) {
            array[curIdx++] = helper[lIdx++];
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(MyMergeSort.mergeSort(new int[] { 2, 5, 4, 8 })));
    }
}