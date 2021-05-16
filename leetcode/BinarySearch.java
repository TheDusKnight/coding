package leetcode;

public class BinarySearch {
    // s3
    public int binarySearch(int[] arr, int target) {
       // corner case
       if (arr == null || arr.length == 0) return -1;
       int left = 0, right = arr.length - 1, mid = 0;

       while (left + 1 < right) {
           mid = left + (right - left) / 2;
           if (arr[mid] < target) left = mid;
           else if (arr[mid] > target) right = mid;
           else return mid;
       }
       if (arr[left] == target) return left;
       if (arr[right] == target) return right;

       return -1;
   } 
}
