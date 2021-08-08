package leetcode._0001_TwoSum;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// one pass hashmap，最优解
public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // 使用map因为要返回index
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                int[] res = {i, map.get(complement)};
                return res;
            }
            map.put(nums[i], i); // map.put必须放在map.get后面
        }
        throw new IllegalArgumentException();
    }
    public static void main(String[] args) {
        int[] input = { 3, 3 };
        Solution2 sol = new Solution2();
        System.out.println(Arrays.toString(sol.twoSum(input, 6)));
    }
}

// time: O(n); space: O(n);