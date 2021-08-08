package leetcode;

public class BinarySearch {
    // s3
    public int binarySearch(int[] arr, int target) {
       // corner case
       if (arr == null || arr.length == 0) return -1;
       int left = 0, right = arr.length - 1, mid = 0;

       while (left + 1 < right) { // 左右相邻
           mid = left + (right - left) / 2;
           if (arr[mid] < target) left = mid; // mid+1
           else if (arr[mid] > target) right = mid; // mid-1
           else return mid;
       }
       if (arr[left] == target) return left;
       if (arr[right] == target) return right;

       return -1;
   }

   public static void main(String[] args) {
       int[] arr = new int[] {1,2,3,4,5};
       int target = 3;
       BinarySearch bs = new BinarySearch();
       System.out.println(bs.binarySearch(arr, target));
   }
}
