package leetcode._0001_TwoSum;
import java.util.*;

// one pass hashmap
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // int tmp = map.get(complement);
            // if (tmp == 1) System.out.println("find!");
            if (map.containsKey(complement) && i != map.get(complement)) {
                int[] res = {i, map.get(complement)};
                return res;
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException();
    }
    public static void main(String[] args) {
        int[] input = { 3, 3 };
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.twoSum(input, 6)));
    }
}