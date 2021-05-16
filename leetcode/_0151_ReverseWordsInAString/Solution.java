package leetcode._0151_ReverseWordsInAString;

// s3: 全局rotate之后word rotate, 另一种做法split by word但不推荐因为没法解决带引号的情况
class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() <= 1) return s;
        String str = clearExtraSpace(s);
        char[] chars = str.toCharArray();
        // 全局reverse string
        swap(0, chars.length-1, chars);
        
        // reverse each word
        int slow = 0;
        for (int fast = 0; fast < chars.length; fast++) {
            if (fast+1 < chars.length && chars[fast+1] == ' ') {
                swap(slow, fast, chars);
                slow = fast+2;
            }
        }
        // post-processing
        if (slow < chars.length) swap(slow, chars.length-1, chars);
        
        // clean extra space between each word
        String res = cleanSpace(chars);
        
        return res;
    }
    
    private String clearExtraSpace(String s) {
        int left = 0, right = s.length() - 1;
        while (left < s.length() && s.charAt(left) == ' ') left++;
        while (right >= 0 && s.charAt(right) == ' ') right--;

        if (left > right) return "";
        return s.substring(left, right+1);
    }
    
    private String cleanSpace(char[] a) {
        int i = 0, j = 0, n = a.length;
        while (j < n) {
            while (j < n && a[j] == ' ') j++;
            while (j < n && a[j] != ' ') a[i++] = a[j++];
            while (j < n && a[j] == ' ') j++;
            if (j < n) a[i++] = ' ';
        }
        return new String(a).substring(0, i);
    }
    
    private void swap(int left, int right, char[] chars) {
        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
    }
}
