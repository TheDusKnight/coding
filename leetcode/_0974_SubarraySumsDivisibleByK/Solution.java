package leetcode._0974_SubarraySumsDivisibleByK;

import java.util.HashMap;

// prefix sum 存取模的结果 + hashMap
public class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // cc
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;

        for (int a : nums) {
            sum = (sum + a) % k;
            if (sum < 0) // Because -1 % 5 = -1, but we need the positive mod 4。0不需要变
                sum += k; // 我们需要把负余数转化为对应的正余数转化前后都可以被k整除，但如果不转换4出现过的次数没法算到-1头上。总之要把正负余数次数合并
            int tmp = map.getOrDefault(sum, 0); // tmp是之前[0,i]的余数的count
            count += tmp; // 如果[0,i]和[0,j] 余数相同，那么sum[i, j] is divisible by K. 因为两个一减余数抵消了
            map.put(sum, tmp + 1); // tmp + 1是当前[0,j]的sum的count
        }
        return count;
    }
}

// time: O(n); space: O(k)
