package jianzhioffer.array._05;

public class Solution2 {
    // 字符数组
    public String replaceSpace(String s) {
        int len = s.length();
        char[] arr = new char[len*3];

        int size = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                arr[size] = '%';
                arr[size+1] = '2';
                arr[size+2] = '0';
                size = size+3;
            } else {
                arr[size] = s.charAt(i);
                size++;
            }
        }

        return new String(arr, 0, size);
    }
}

// time: O(n); space: O(n)
