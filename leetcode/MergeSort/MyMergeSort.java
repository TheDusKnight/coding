package leetcode.MergeSort;

import java.util.Arrays;

public class MyMergeSort {
    public static int[] mergeSort(int[] array) {
        if (array == null)
            return null;

        int len = array.length;
        int[] helper = new int[len];
        mergeSort(array, helper, 0, len - 1);
        return array;
    }

    private static void mergeSort(int[] array, int[] helper, int l, int r) {
        if (l == r)
            return;

        int m = l + (r - l) / 2;
        mergeSort(array, helper, l, m);
        mergeSort(array, helper, m + 1, r);
        merge(array, helper, l, m, r);
    }

    private static void merge(int[] array, int[] helper, int l, int m, int r) {
        for (int i = 0; i < array.length; i++) {
            helper[i] = array[i];
        }

        int lIdx = l, rIdx = m + 1, cur = l;
        while (lIdx <= m && rIdx <= r) {
            if (helper[lIdx] < helper[rIdx]) {
                array[cur++] = helper[lIdx++];
            } else {
                array[cur++] = helper[rIdx++];
            }
        }

        while (lIdx <= m) {
            array[cur++] = helper[lIdx++];
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(MyMergeSort.mergeSort(new int[] { 2, 5, 4, 8 })));
    }
}