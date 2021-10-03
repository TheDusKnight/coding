package leetcode.FindTheClosestPairFromTwoSortedArrays;

import java.util.Arrays;

// 从两个array中各找一个元素组成的pair和离target最近
// 双指针站肩一个array的最小idx，一个array的最大idx，和target比较大小
public class Solution {
    public static int[] closestPair(int[] arr1, int[] arr2, int target) {
        // cc

        int n1 = arr1.length, n2 = arr2.length;
        int left = 0, right = n2-1;
        int diff = Math.max(Math.abs(arr1[n1-1] + arr2[n2-1] - target), Math.abs(arr1[0] + arr2[0] - target));
        int[] res = new int[2];

        while (left < n1 && right >= 0) {
            int curClosest = Math.abs(arr1[left] + arr2[right] - target);
            if (curClosest < diff) {
                diff = curClosest;
                res[0] = arr1[left];
                res[1] = arr2[right];
            }
            if (arr1[left] + arr2[right] > target) {
                right--;
            } else {
                left++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {1, 4, 5, 7};
        int[] arr2 = new int[] {10, 20, 30, 40};
        int target = 50;
        System.out.println(Arrays.toString(Solution.closestPair(arr1, arr2, target)));
    }
}

// time: O(N); space: O(1);