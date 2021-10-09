package leetcode;

public class BinarySearch {
    // s3
    public int binarySearch(int[] arr, int target) {
       // corner case
       if (arr == null || arr.length == 0) return -1;
       int left = 0, right = arr.length - 1, mid = 0;

    //    while (left + 1 < right) { // 左右相邻
    //        mid = left + (right - left) / 2;
    //        if (arr[mid] < target) left = mid; // mid+1
    //        else if (arr[mid] > target) right = mid; // mid-1
    //        else return mid;
    //    }
    //    if (arr[left] == target) return left;
    //    if (arr[right] == target) return right;


        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] < target) left = mid+1;
            else if (arr[mid] > target) right = mid-1;
            else break;
        }
       
        // if (arr[left] == target) return left;
        if (arr[mid] == target) return mid;
        return -1;
   }

   public static void main(String[] args) {
       int[] arr = new int[] {4,6,7,8};
    //    int[] arr = new int[] {2};
       int target = 8;
       BinarySearch bs = new BinarySearch();
       System.out.println(bs.binarySearch(arr, target));
   }
}
