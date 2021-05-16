package leetcode._0796_RotateString;

// string operation, 和LC151 Rotate String类似
// 全局reverse后，两边局部reverse
class Solution {
    public boolean rotateString(String A, String B) {
        if (A.length() == 0 && B.length() == 0) return true;
        if (A.length() == 0 && B.length() != 0) return false;
        if (A.length() == 1 && B.length() != 1) return false;
        
        char[] arr = A.toCharArray();
        swap(0, arr.length-1, arr);
        
        for (int fast = 0; fast+1 < arr.length; fast++) {
            swap(0, fast, arr);
            swap(fast+1, arr.length-1, arr);
            String tmp = new String(arr);
            if (tmp.equals(B)) return true;
            // swap back to keep original
            swap(0, fast, arr);
            swap(fast+1, arr.length-1, arr);
        }
        return false;
    }
    
    private void swap(int left, int right, char[] arr) {
        while (left < right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
}
