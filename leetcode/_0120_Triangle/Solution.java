package leetcode._0120_Triangle;
import java.util.*;

// recursion
// 注意时间复杂度, leetcode超时
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // triangle是否有cc情况？

        int res = helper(triangle, 0, 0);
        return res;
    }

    private int helper(List<List<Integer>> triangle, int i, int j) {
        // base case leaf node
        if (i == triangle.size()-1) {
            return triangle.get(i).get(j);
        }

        int left = helper(triangle, i+1, j);
        int right = helper(triangle, i+1, j+1);

        return Math.min(left, right) + triangle.get(i).get(i);
    }
}

// time: O(2^n) n是tree的高度