package leetcode._1331_RankTransformOfAnArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// array sort + hashmap
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if (arr == null || arr.length == 0) return new int[]{};

        int[] res  = Arrays.copyOf(arr, arr.length);
        Arrays.sort(res);
        Map<Integer, Integer> rank = new HashMap<>(); // key is arr element, value is rank
        for (int x: res) {
            rank.putIfAbsent(x, rank.size() + 1);
        }
        // int count =  0; // 另一种写法
        // for (int x: res) {
        //     if (!rank.containsKey(x))
        //         rank.put(x, ++count);
        // }
        
        // 按照input的顺序输出rank
        for (int i = 0; i < arr.length; i++) {
            res[i] = rank.get(arr[i]);
        }
        return res;
    }
}

// time: O(n*log(n)). n is the length of arr; space: O(n);