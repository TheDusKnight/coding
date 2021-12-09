package leetcode._1356_SortIntegersByTheNumberOf1Bits;

import java.util.Arrays;

// bit. 不是最优解
class Solution {
    public int[] sortByBits(int[] arr) {
        if (arr == null || arr.length == 0) return arr;
        
        Integer[] arr2 = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }
        
        Arrays.sort(arr2, (o1, o2) -> {
            int count1 = getBitsOfOne(o1);
            int count2 = getBitsOfOne(o2);
            if (count1 < count2) return -1;
            else if (count1 > count2) return 1;
            else return o1 - o2;
        });
        

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr2[i];
        }
        
        return arr;
    }
    
    private int getBitsOfOne(int num) {
        int mask = 1, count = 0;
        for (int i = 0; i < 32; i++) {
            count += mask & (num >> i);
        }
        
        return count;
    }
}

// time: O(N*log(N)); space: O(1);
