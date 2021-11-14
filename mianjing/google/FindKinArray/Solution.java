package mianjing.google.FindKinArray;

import java.util.HashMap;
import java.util.Map;

// Google OA
// 给一个array A, 求最大k, k = |i - j| ==|Ai - Aj|,
// 举个栗子： 2342372 当i == 0， j ==5 时 K=|0 - 5|==|2-7|=5
// 思路是： |i - j| ==|Ai - Aj|  ->  i - j == Ai - Aj 或者 i - j == Aj - Ai  -> i - A == j - A[j] 或者 i + Ai == j + Aj; 用两个HashMap 分别记录
// i - Ai map to i 和 i + Ai map to i 的情况，遍历一遍A 如果碰到 hashmap里已经有i- Ai 就看是否要更新K； i + Ai同理
public class Solution {
    public int getK(int[] A) {
        // cc

        int k = Integer.MIN_VALUE;
        Map<Integer, Integer> minus = new HashMap<>();
        Map<Integer, Integer> add = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            minus.put(i-A[i], i);
            add.put(i+A[i], i);
        }

        for (int j = 0; j < A.length; j++) {
            if (minus.containsKey(j-A[j])) k = Math.max(k, Math.abs(minus.get(j-A[j]) - j));
            if (add.containsKey(j+A[j])) k = Math.max(k, Math.abs(add.get(j+A[j]) - j));
        }

        return k;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] A = {2,3,4,2,3,7,2};
        System.out.println(sol.getK(A));
    }
}
