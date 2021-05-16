package leetcode._0186_ReverseWordsInAStringII;

// string operation, LC151 类似
// 全局reverse后局部reverse
class Solution {
    public void reverseWords(char[] s) {
        if (s == null || s.length <= 1) return;
        
        swap(0, s.length-1, s);
        
        int slow = 0;
        for (int fast = 0; fast < s.length; fast++) {
            if (fast+1 < s.length && s[fast+1] == ' ') {
                swap(slow, fast, s);
                slow = fast+2;
            }
        }
        // post processing
        if (slow < s.length) swap(slow, s.length-1, s);
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
